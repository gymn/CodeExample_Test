package com.gymn.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author hunan
 * @Date 2018/7/1
 * @Time 上午10:31
 */
public class AopMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:config/spring.local/spring-*.xml");
        CoreController coreController = (CoreController) ctx.getBean(CoreController.class);

        String res = coreController.show();
        System.out.println(res);
    }
}
