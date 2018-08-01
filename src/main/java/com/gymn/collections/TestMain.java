package com.gymn.collections;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:hunan
 * Date:2018/5/21
 */
public class TestMain {
    @Test
    public void testLinkedHashSet(){
        Collection set = new LinkedList();
        set.add("aaa");
        System.out.println(((LinkedList) set).get(0));
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(2);
        System.out.println(list.get(0).toString());
    }
}
