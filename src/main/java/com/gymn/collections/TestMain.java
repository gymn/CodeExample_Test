package com.gymn.collections;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.lang.reflect.Array;
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
        Map<Integer, Object > testMap = new HashMap<>();
        testMap.put(Integer.valueOf(1), 1.1);
        Long i = Long.valueOf(testMap.get(1).toString());
        System.out.println(i);
    }

    @Test
    public void testUnion() {
        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = Arrays.asList(3,4,5,6);
        List<Integer> c = (List) CollectionUtils.union(a,b);

        System.out.println(c);
    }

    @Test
    public void testIntersection() {
        Set<String> sa = new HashSet<>(Arrays.asList("a","b","c","d"));
        Set<String> sb = new HashSet<>(Arrays.asList("d","e","f","g"));
        boolean res = sa.retainAll(sb);
        System.out.println(sb);
    }
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList(null);
        System.out.println(JSON.toJSONString(stringList));
    }

    @Test
    public void testSetEquals() {
        Set set1 = new HashSet(Arrays.asList(1,2,3));
        Set set2 = new HashSet(Arrays.asList(2,1,3));
        System.out.println(set1.equals(set2));
    }

    @Test
    public void tt() {
        String msgBuilderConfig = "{\"45\":\"apolloMsgBuilder\"}";
        Map<Integer, String> config = JSON.parseObject(msgBuilderConfig, Map.class);
        System.out.println(config.get(String.valueOf(45)));
    }
}
