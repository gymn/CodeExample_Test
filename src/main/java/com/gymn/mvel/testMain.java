package com.gymn.mvel;

import org.junit.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hunan
 * @Date 2018/10/29
 * @Time 8:10 PM
 */
public class testMain {

    @Test
    public void testMvel() {
        String rule1 = "n<5";
        Serializable serializable = MVEL.compileExpression(rule1);
        Map<String, Object> args = new HashMap<>();
        args.put("n",3);
        boolean res = (Boolean) MVEL.executeExpression(serializable, args);
        System.out.println(res);
    }
}
