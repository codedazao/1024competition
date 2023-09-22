package org.example.server.annotaion;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用于标识过滤器优先级的注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterOrder {
    int priority = -100;
}
