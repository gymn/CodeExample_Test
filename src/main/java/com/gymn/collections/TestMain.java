package com.gymn.collections;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testMap() {
        Map<Integer, String > testMap = new HashMap<>();
        testMap.put(Integer.valueOf(1), "one");
        System.out.println(testMap.get(1));
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(null);
        System.out.println(JSON.toJSONString(stringList));
    }
}
