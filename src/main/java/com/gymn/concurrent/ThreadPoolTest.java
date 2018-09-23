package com.gymn.concurrent;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author hunan
 * @Date 2018/8/27
 * @Time 下午4:37
 */
@Component
public class ThreadPoolTest {
    private static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(111);
        });
        Thread t2 = new Thread(()->{
            System.out.println(112);
        });

        fixedThreadPool.execute(t);
        fixedThreadPool.execute(t2);
    }
}
