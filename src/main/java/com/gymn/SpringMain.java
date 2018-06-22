package com.gymn;

import com.gymn.orm.dao.UserAccountMapper;
import com.gymn.orm.entity.UserAccount;
import com.gymn.orm.entity.UserAccountExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @Author hunan
 * @Date 2018/6/8
 * @Time 下午2:30
 */
public class SpringMain {

    static int insertValue(UserAccountMapper userAccountMapper){
        UserAccount userAccount = new UserAccount();
        userAccount.setName("Lily");
        userAccount.setAddress("shanghai");
        userAccount.setCity(0);
        userAccount.setCreate_time(new Date());
        userAccount.setUpdate_time(new Date());
        userAccount.setIsDeleted((byte)0);

        int n = userAccountMapper.insert(userAccount);
        System.out.println(userAccount.getID());
        return n;
    }
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:config/spring.local/spring-*.xml");
        UserAccountMapper userAccountDao = (UserAccountMapper) ctx.getBean("userAccountMapper");

        //insertValue(userAccountDao);
        UserAccountExample example = new UserAccountExample();
        UserAccountExample.Criteria criteria = example.createCriteria();

        criteria.andIDEqualTo(2).andIsDeletedEqualTo((byte)0);

        List<UserAccount> userAccountList = userAccountDao.selectByExample(example);
        for (UserAccount userAccount : userAccountList) {
            System.out.println(userAccount);
        }
    }
}
