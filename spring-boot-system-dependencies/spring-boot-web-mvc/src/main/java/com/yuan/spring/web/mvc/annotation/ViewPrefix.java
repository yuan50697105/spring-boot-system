package com.yuan.spring.web.mvc.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewPrefix {
    String value() default "";
}
