package com.gymn.common;

/**
 * @Author hunan
 * @Date 2018/6/25
 * @Time 下午7:09
 */
public enum TypeEnum {
    A_TYPE(1,"a"),
    B_TYPE(2,"b"),
    C_TYPE(3,"c");

    private final int code;
    private final String desc;

    TypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
