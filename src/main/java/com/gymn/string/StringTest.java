package com.gymn.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hunan
 * @Date 2018/6/25
 * @Time 下午3:21
 */
public class StringTest {
    public static void main(String[] args) {
        boolean res = Arrays.asList("a,c,d,e,s".split(",")).contains("a");
        System.out.println(res);
    }

    @Test
    public void testSplit() {
        String sql = "SELECT * from users u order by u.id";
        System.out.println(sql.substring(0,sql.indexOf("order by")));
    }
}
