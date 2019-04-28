package com.gymn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author hunan
 * @Date 2018/6/29
 * @Time 下午9:29
 */
public class TestFastJson {
    @Test
    public void test01() {
        System.out.println(JSON.parseObject("{55}").get("a"));
    }
}
