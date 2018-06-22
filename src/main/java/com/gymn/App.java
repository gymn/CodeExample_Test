package com.gymn;

import com.gymn.aop.CoreController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:config/spring.local/spring-*.xml");
        CoreController cc = (CoreController) ctx.getBean("coreCtrl");
        System.out.println(cc.show());
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
    }
}
