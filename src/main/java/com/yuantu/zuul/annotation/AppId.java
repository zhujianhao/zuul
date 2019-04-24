package com.yuantu.zuul.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *@Author: zjh
 *@Date: Created on 10:22 2019/4/19
 *@Modofy by:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppId {

    String serviceName() ;

}


