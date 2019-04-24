package com.yuantu.zuul.serviceCheck;


import org.springframework.http.HttpRequest;

import javax.servlet.ServletRequest;

/***
 *@Author: zjh
 *@Date: Created on 10:25 2019/4/19
 *@Modofy by:
 */
public interface BaseCheck {

    boolean check(ServletRequest httpRequest);
}
