package com.gymn.common;

import org.junit.Test;

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
        Integer n = 5;
        Integer n1 = null;
        System.out.println(n.equals(n1));
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
