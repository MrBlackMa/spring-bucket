package com.malixi.springboot.malixispringboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/12 - 17:30
 * @Description: 自定义注解
 * @version: 1.0
 */

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD}) //类的作用范围
@Retention(RetentionPolicy.RUNTIME) //运行时用的最多
@Inherited
public @interface MyAnnotation {
    // 定义的方式看起来是方法 但是实际是使用注解的时候写的参数名称,默认是名称是value
    // 注解里面填写的所有方法 都需要在使用注解的时候添加值,因此可以包含默认值
//    String name() default "malixi";
//    int age() default  12;
//    int id() default 1;
//    String [] likes() default {"A,B,C"};
    String value() default "";
}
