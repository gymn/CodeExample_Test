package com.gymn.inherit;

/**
 * @Author hunan
 * @Date 2018/8/13
 * @Time 上午10:09
 */
public class Son extends Parent{
    private Integer bar;

    public Integer getBar() {
        return bar;
    }

    public void setBar(Integer bar) {
        this.bar = bar;
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.setFoo("aa");
        System.out.println(son.getFoo());
    }
}
