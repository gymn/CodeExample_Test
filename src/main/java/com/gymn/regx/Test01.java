package com.gymn.regx;

/**
 * Author:hunan
 * Date:2018/5/11
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++) {
            double auc = Math.random();
            System.out.print(auc+"\t");
            Thread.sleep(10);
        }
    }
}
