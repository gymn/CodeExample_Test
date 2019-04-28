package com.gymn.reflect;

import com.gymn.aop.CoreController;
import com.gymn.aop.CoreControllerImpl;
import com.gymn.orm.entity.UserAccount;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author hunan
 * @Date 2018/6/29
 * @Time 上午10:34
 */
public class Test01 {
    @Test
    public void testClassName(){
        CoreController coreController = new CoreControllerImpl();
        System.out.println(coreController.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Class clazz = UserAccount.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
