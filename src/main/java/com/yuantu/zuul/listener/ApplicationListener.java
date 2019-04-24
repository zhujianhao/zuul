package com.yuantu.zuul.listener;

import com.yuantu.zuul.annotation.AppId;
import com.yuantu.zuul.serviceCheck.BaseCheck;
import com.yuantu.zuul.staticValues.MapValues;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Method;
import java.util.Map;

/***
 *@Author: zjh
 *@Date: Created on 10:27 2019/4/19
 *@Modofy by:
 */
public class ApplicationListener implements ServletContextListener,ApplicationContextAware {

    ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initMethodAndHandler();
    }

    private void initMethodAndHandler() {
        Map<String, BaseCheck> checkMap = applicationContext.getBeansOfType(BaseCheck.class);
        for (BaseCheck check : checkMap.values()) {
            Class clazz = check.getClass();
            AppId appId =(AppId)clazz.getAnnotation(AppId.class);
            if(appId==null){
                System.err.println("service{"+clazz.getName()+"}没有定义serviceName  被跳过，并未生效");
                continue;
            }
            String key = appId.serviceName();
            MapValues.checkMap.put(key,check);
        }
    }

}
