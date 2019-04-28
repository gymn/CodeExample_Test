package com.gymn.common;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author hunan
 * @Date 2018/6/25
 * @Time 下午6:09
 */
public class JBase {
    @Test
    public void testChar() {
        System.out.println((int)'1');
    }

    @Test
    public void testInteger() {
        Integer n = 13914;
        Integer n1 = null;
        System.out.println(!Integer.valueOf(2).equals(n1));
    }

    @Test
    public void  testCount() {
        List<Integer> intArr = IntStream.range(0,9).boxed().collect(Collectors.toList());
        int count  = 0, divide = intArr.size()/10, progress = 0;
        for (Integer n : intArr) {
            count++;
            if(count%divide==0) {
                System.out.println("current progress:"+(++progress*10)+"%");
            }
        }
    }

    public void testEnum() {
        try {
            int type = 1;
            TypeEnum typeE = null;
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.getCode() == type) {
                    typeE = typeEnum;
                    break;
                }
            }

            if (typeE == null) {
                throw new IllegalArgumentException("类型错误！");
            }
            switch (typeE) {
                case A_TYPE:
                case C_TYPE: {
                    System.out.println(4);
                }
                break;
                case B_TYPE:
                    System.out.println(2);
                    break;
                default:
                    System.out.println(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
