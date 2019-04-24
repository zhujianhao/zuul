package com.yuantu.zuul.serviceCheck;


import com.yuantu.zuul.annotation.AppId;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;

/***
 *@Author: zjh
 *@Date: Created on 10:25 2019/4/19
 *@Modofy by:
 */
@AppId(serviceName = "data-center")
@Component
public class CheckeDataCenter  implements BaseCheck{


    @Override
    public boolean check(ServletRequest httpRequest) {
        return true;
    }


}
