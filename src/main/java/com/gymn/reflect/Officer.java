package com.gymn.reflect;

/**
 * @author hunan
 * @date 2019/4/29
 * @time 10:35 AM
 */
public class Officer implements Person {
    private String attribute;

    public Officer(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public void speak(String content) {
        System.out.println(content);
    }
}
