package com.gymn.date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author hunan
 * @Date 2018/8/15
 * @Time 下午4:38
 */
public class Test02 {
    @Test
    public void testDateUtil() {
        Date today = new Date();
        Date yesterday = DateUtils.addDays(today, -1);
        Date startDate = DateUtils.addDays(today, -60);

        System.out.println(yesterday);
        System.out.println(startDate);
    }

    @Test
    public void testLocalDate() {
        Date now = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(now);
// 将时分秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        System.out.println(DateUtils.addDays(cal1.getTime(),-3));
    }

    public static void main(String[] args) throws Exception {
        String timeStr = "2017-04-12 23:23:34.289";
        Date startTime = DateUtils.parseDate(timeStr, "yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(startTime);
    }
}
