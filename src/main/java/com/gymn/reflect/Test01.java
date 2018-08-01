package com.gymn.reflect;

import com.gymn.orm.entity.UserAccount;

import java.lang.reflect.Field;

/**
 * @Author hunan
 * @Date 2018/6/29
 * @Time 上午10:34
 */
public class Test01 {
    public static void main(String[] args) {
        Class clazz = UserAccount.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
