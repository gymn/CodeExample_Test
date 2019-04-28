package com.gymn.quartz;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.Date;

/**
 * @author hunan
 * @date 2019/4/4
 * @time 5:35 PM
 */
public class TestQuartz {
    public static void main(String[] args) throws ParseException {
        CronExpression expression = new CronExpression("* * * 4 * ?");
        boolean res = expression.isSatisfiedBy(new Date());
        System.out.println(res);
    }
}