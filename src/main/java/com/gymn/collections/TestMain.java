package com.gymn.collections;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:hunan
 * Date:2018/5/21
 */
public class TestMain {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(2);
        System.out.println(list.get(0).toString());
    }
}
