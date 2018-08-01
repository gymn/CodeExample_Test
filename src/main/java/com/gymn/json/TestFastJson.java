package com.gymn.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Author hunan
 * @Date 2018/6/29
 * @Time 下午9:29
 */
public class TestFastJson {
    @Test
    public void test01() {
        AccountDTO accountDTO = new AccountDTO(66283, 1);
        System.out.println(JSON.toJSON(accountDTO));
    }
}
