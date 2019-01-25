package com.codermi.mybatis.service;

import com.codermi.mybatis.BaseTest;
import com.codermi.mybatis.data.Count;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * @author qiudm
 * @date 2019/1/25 17:52
 * @desc
 */
public class AddCountServiceTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddCountServiceTest.class);

    @Autowired
    private AddCountService addCountService;

    @Test
    public void addCount() throws Exception {
        Count count1 = new Count();

        int threadCount = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                addCountService.addCount(count1);
            }).start();

        }

        Thread.sleep(2000L);

        System.out.println("count1 = " + count1.getNum());
        LOGGER.error("count1:{}", count1);
        for (int i = 0; i < threadCount; i++) {
            countDownLatch.countDown();
        }

        Thread.sleep(10000L);

        LOGGER.error("count2:{}", count1.getNum());
        Thread.sleep(100000L);
    }



}