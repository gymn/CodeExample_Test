package com.gymn.guava;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalNotification;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author hunan
 * @Date 2018/6/27
 * @Time 上午10:22
 */
public class TestCache {
    @Test
    public void testJoiner() {
        String res = Joiner.on("/").join(Arrays.asList());
        System.out.println(res);
    }
    private Cache<String, List<Object>> cache = CacheBuilder.newBuilder()
            .maximumSize(2)
            .expireAfterWrite(20,TimeUnit.MINUTES)
            .removalListener((RemovalNotification<String, List<?>> notification) ->{
                System.out.println(notification.getKey()+" >> 缓存被移除");
            })
            .build();

    public List<Object> getDataFromCache() throws ExecutionException {
        return cache.get("cityInfo",()->{
            List<Object> list = new ArrayList<>();
            list.add("hello");
            list.add("world");
            return list;
        });
    }
}
