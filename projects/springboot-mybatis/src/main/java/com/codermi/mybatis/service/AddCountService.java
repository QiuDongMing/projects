package com.codermi.mybatis.service;

import com.codermi.mybatis.aspect.annotaion.RedisLock;
import com.codermi.mybatis.data.Count;
import org.springframework.stereotype.Service;

/**
 * @author qiudm
 * @date 2019/1/25 17:46
 * @desc
 */
@Service
public class AddCountService {


    @RedisLock(key = "addcount")
    public Count addCount(Count count)  {
        count.setNum(count.getNum() + 1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }



}
