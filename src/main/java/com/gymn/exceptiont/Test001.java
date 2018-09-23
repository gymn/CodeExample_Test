package com.gymn.exceptiont;

/**
 * @Author hunan
 * @Date 2018/9/13
 * @Time 下午8:24
 */
public class Test001 {
    public static void main(String[] args) {
        Integer n=null;
        try {
            System.out.println(n == 1);
        }catch (NullPointerException npe) {
            System.out.println("npe get!");
            throw npe;
        }
    }
}
