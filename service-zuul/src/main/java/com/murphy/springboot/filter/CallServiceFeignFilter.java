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
public class CallServiceFeignFilter implements ICallServiceFilter {

    private static Logger logger = LoggerFactory.getLogger(CallServiceFeignFilter.class);

    @Override
    public Object execute() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String innId = request.getParameter("innId");
        if (StringUtils.isBlank(innId)) {
            logger.warn("call service one need parameter innId, but innId is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(Integer.parseInt(ResultCode.PARAM_ERROR.getStatus()));
            try {
                ctx.getResponse().setHeader("Content-Type", "application/json;charset=utf-8");
                ctx.getResponse().getWriter().write(JSON.toJSONString(new Result(ResultCode.PARAM_ERROR)));
            } catch (Exception e) {
            }
            return null;
        }
        return null;
    }

}
