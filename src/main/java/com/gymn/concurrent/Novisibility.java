package com.gymn.concurrent;

/**
 * @author hunan
 * @date 2019/2/23
 * @time 9:27 PM
 */
public class Novisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();

        Thread.sleep(1000);
        number = 42;
        ready = true;
    }
}
