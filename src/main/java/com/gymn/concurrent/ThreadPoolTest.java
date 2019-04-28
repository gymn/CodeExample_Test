package com.gymn.concurrent;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author hunan
 * @Date 2018/8/27
 * @Time 下午4:37
 */
@Component
public class ThreadPoolTest {
    private static final ExecutorService fixedThreadPool = Executors.newSingleThreadExecutor();
    int n = 0;

    static void execute() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start...");
        System.out.println(100/0);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }

    private String test() {
        CompletableFuture<Void> futureA = CompletableFuture.
                runAsync(() -> execute(),fixedThreadPool)
                .whenComplete((s, e) -> {
                    if (s != null) {
                        System.out.println(s);//未执行
                    }
                    if (e == null) {
                        System.out.println(s+"aa");//未执行
                    } else {
                        System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
                    }
                });
        return "hello";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String res = new ThreadPoolTest().test();
        System.out.println(res);
    }
}
