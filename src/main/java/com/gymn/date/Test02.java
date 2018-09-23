package com.gymn.date;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @Author hunan
 * @Date 2018/8/15
 * @Time 下午4:38
 */
public class Test02 {
    public static void main(String[] args) throws Exception{
        String timeStr = "2017-04-12 23:23:34.289";
        Date startTime = DateUtils.parseDate(timeStr, "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(startTime);
    }
}
