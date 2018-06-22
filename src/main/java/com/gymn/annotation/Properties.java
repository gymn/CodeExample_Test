package com.gymn.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Properties {
    String name() default "";
    int age() default 0;
}
