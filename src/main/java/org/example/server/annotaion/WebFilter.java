package org.example.server.annotaion;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
* 标注哪些类时过滤器类
* */
@Retention(RetentionPolicy.RUNTIME)
public @interface WebFilter {

}
