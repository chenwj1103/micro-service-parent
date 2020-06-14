package com.chenwj.microservice.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :  chen weijie
 * @Date: 2020-06-14 22:34
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * <p>
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        log.info("filterType pre");
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 上面指定filterType：pre表示在路由之前拦截请求，shouldFilter始终为true，表示永远过滤，并执行run方法。
     * <p>
     * requestContext.setSendZuulResponse(false);表示不继续转发该请求。
     * requestContext.setResponseStatusCode(401);返回的状态码，这里为401
     * requestContext.setResponseBody("token is invalid");返回的内容，可以指定为一串json
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());

        String accessToken = request.getParameter("access_token");
        if (StringUtils.isBlank(accessToken) || !"test".equals(accessToken)) {
            // zuul过滤该请求
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is invalid");
            log.info("the request {} is fail, the token is invalid", request.getRequestURL().toString());
        } else {
            log.info("the request {} is ok", request.getRequestURL().toString());
        }
        return null;
    }
}
