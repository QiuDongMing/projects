package com.codermi.mybatis.aspect;

import com.codermi.mybatis.aspect.annotaion.RedisLock;
import com.codermi.mybatis.aspect.annotaion.RedisLockParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author qiudm
 * @date 2019/1/25 16:27
 * @desc
 */
@Aspect
@Component
public class RedisLockAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Pointcut("@annotation(com.codermi.mybatis.aspect.annotaion.RedisLock)")
    public void redisLockPointcut() {

    }


    @Around("redisLockPointcut()")
    public Object interceptor(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        RedisLock redisLock = method.getAnnotation(RedisLock.class);
        String redisKey = redisLock.key() + getLockKey(method, args);
        Object object = null;
        boolean lock = this.lock(redisKey, redisLock.expire());
        //没有获取到锁
        if (!lock) {
//            int times = 3;
//            while (times > 0) {
//                lock = this.lock(redisKey, redisLock.expire());
//                if (lock) {
//                    break;
//                }
//                try {
//                    TimeUnit.MILLISECONDS.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                times--;
//            }
            LOGGER.error("not get lock" + redisLock.msg());
            throw new RuntimeException(redisLock.msg());
        }
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            this.unlock(redisKey);
        }
        return object;
    }


    private String getLockKey(Method method, Object[] args) {
        StringBuilder sb = new StringBuilder();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                if (parameterAnnotations[i][j] instanceof RedisLockParam) {
                    sb.append(args[i].toString());
                }
            }
        }
        return sb.toString();
    }


    private boolean lock(String redisKey, int expire) {
        long expireMillis = System.currentTimeMillis() + expire * 1000;
        boolean locked = stringRedisTemplate.opsForValue()
                .setIfAbsent(redisKey, String.valueOf(expireMillis));
        if (locked) {
            stringRedisTemplate.expire(redisKey, expire, TimeUnit.SECONDS);
            return true;
        }
        String expireTimeMillisDb = stringRedisTemplate.opsForValue().get(redisKey);

        if (expireTimeMillisDb == null || Long.valueOf(expireTimeMillisDb) < System.currentTimeMillis()) {//过期
            String newExpireTimeMillis = String.valueOf(System.currentTimeMillis() + expire * 1000);
            String oldExpireTimeMillis = stringRedisTemplate.opsForValue()
                    .getAndSet(redisKey, newExpireTimeMillis);
            if (oldExpireTimeMillis == null
                    || expireTimeMillisDb == oldExpireTimeMillis
                    || expireTimeMillisDb.equals(oldExpireTimeMillis)) {
                return true;
            }
        }

        return false;
    }


    private void unlock(String redisKey) {
        stringRedisTemplate.delete(redisKey);
    }


}
