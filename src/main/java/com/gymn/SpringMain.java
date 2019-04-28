package com.gymn;

import com.gymn.inherit.Task;
import com.gymn.inherit.TaskManager;
import com.gymn.orm.dao.UserAccountMapper;
import com.gymn.orm.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @Author hunan
 * @Date 2018/6/8
 * @Time 下午2:30
 */
public class SpringMain {
    @Autowired
    TaskManager taskManager;

    static int insertValue(UserAccountMapper userAccountMapper) {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("Lily");
        userAccount.setAddress("shanghai");
        userAccount.setCity(0);
        userAccount.setCreate_time(new Date());
        userAccount.setUpdate_time(new Date());
        userAccount.setIsDeleted((byte) 0);

        int n = userAccountMapper.insert(userAccount);
        System.out.println(userAccount.getID());
        return n;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:config/spring.local/spring-*.xml");
        Task task = (Task) ctx.getBean("aTask");

        System.out.println(task.getClass());
    }
}
