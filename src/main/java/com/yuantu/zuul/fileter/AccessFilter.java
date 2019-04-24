package com.yuantu.zuul.fileter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yuantu.zuul.serviceCheck.BaseCheck;
import com.yuantu.zuul.staticValues.MapValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/***
 *@Author: zjh
 *@Date: Created on 17:10 2019/4/18
 *@Modofy by:
 */
public class AccessFilter  extends ZuulFilter {

    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to{}", request.getMethod(),
                request.getRequestURL().toString());
        String key =request.getParameter("service");
        BaseCheck baseCheck = MapValues.checkMap.get(key);
        if(!baseCheck.check(request)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("check ok");
        return null;

    }
}
