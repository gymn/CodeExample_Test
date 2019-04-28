package com.gymn.aop;

import org.springframework.context.ApplicationContext;

/**
 * @Author hunan
 * @Date 2018/9/23
 * @Time 下午5:54
 */
public class SpringContextUtil {
    private static ApplicationContext springContext;

    public static void init(ApplicationContext applicationContext) {
        springContext = applicationContext;
    }

    public static Object getBean(Class clz) {
        return springContext.getBean(clz);
    }
}
