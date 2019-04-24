package com.yuantu.zuul.staticValues;

import com.yuantu.zuul.serviceCheck.BaseCheck;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 *@Author: zjh
 *@Date: Created on 10:33 2019/4/19
 *@Modofy by:
 */
public class MapValues {

    public static Map<String,BaseCheck> checkMap = new ConcurrentHashMap<>();

}
