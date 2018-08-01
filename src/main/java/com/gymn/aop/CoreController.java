package com.gymn.aop;

import com.gymn.aop.annotation.AjaxResponse;
import org.springframework.stereotype.Component;

/**
 * Author:hunan
 * Date:2018/5/2
 */
@Component("coreCtrl")
public class CoreController {
    @AjaxResponse(status = "yes")
    public String greet(String name){
        return "hello "+name;
    }

    public String show(){
        return "110";
    }
}
