package com.gymn.aop;

import com.gymn.aop.annotation.AjaxResponse;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * Author:hunan
 * Date:2018/5/2
 */
@Component
public class CoreControllerImpl implements CoreController{
    @AjaxResponse(status = "yes")
    public String greet(String name) {
        return "hello "+name;
    }

    @Override
    public String invokeGreet() {
        return ((CoreControllerImpl)AopContext.currentProxy()).greet("hunan");
    }
    public String show(){
        return "110";
    }
}
