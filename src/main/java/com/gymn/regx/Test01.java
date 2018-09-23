package com.gymn.regx;

import org.junit.Test;

/**
 * Author:hunan
 * Date:2018/5/11
 */
public class Test01 {
    @Test
    public void test02(){
        String recordId = "03aa9964d0c68230d03607f505f18031ea10-quickcall";
        System.out.println(recordId.matches("\\d{20}-\\d{6}"));
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++) {
            double auc = Math.random();
            System.out.print(auc+"\t");
            Thread.sleep(10);
        }
    }
}
