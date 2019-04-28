package com.gymn.inherit;

import com.gymn.orm.dao.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hunan
 * @Date 2019/1/4
 * @Time 1:29 PM
 */
@Service
public class TaskManager {
    @Autowired
    UserAccountMapper userAccountMapper;

    public void submitTask() {

    }



    public static void main(String[] args) {
        Task task = new ATask();
        System.out.println(task.getClass().getSimpleName());
    }
}
