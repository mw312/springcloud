package com.murphy.springboot.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.context.RequestContext;
import com.tomasky.core.bean.Result;
import com.tomasky.core.enums.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author momo
 */
@Component
public class CallServiceOneFilter implements ICallServiceFilter {

    private static Logger logger = LoggerFactory.getLogger(CallServiceOneFilter.class);

    @Override
    public Object execute() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getParameter("token");
        if (StringUtils.isBlank(accessToken)) {
            logger.warn("call service one need token, but token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().setHeader("Content-Type", "application/json;charset=utf-8");
                ctx.getResponse().getWriter().write(JSON.toJSONString(new Result(ResultCode.UNAUTHORIZED)));
            } catch (Exception e) {
            }
            return null;
        }
        return null;
    }

}
