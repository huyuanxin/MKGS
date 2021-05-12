package org.graduation.knowledge.aop;

import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.graduation.knowledge.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BlockException 异常接口，其子类为Sentinel五种规则异常的实现类
 *
 * @author huyuanxin
 */
@Component
public class SentinelExceptionHandler implements BlockExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(SentinelExceptionHandler.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        if (e instanceof FlowException) {
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtil.error(HttpStatus.HTTP_GATEWAY_TIMEOUT, "请求数量过多,过段时间再来吧")));
            logger.info(e + ":发生服务限流");
        } else if (e instanceof AuthorityException) {
            logger.info(e + ":发生权限拦截");
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtil.error(HttpStatus.HTTP_FORBIDDEN, "授权异常")));
        } else if (e instanceof DegradeException) {
            logger.info(e + ":发生服务降级");
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtil.error(HttpStatus.HTTP_BAD_METHOD, "降级异常")));
        } else if (e instanceof ParamFlowException) {
            logger.info(e + ":发生参数限流");
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtil.error(HttpStatus.HTTP_BAD_GATEWAY, "参数限流异常")));
        } else if (e instanceof SystemBlockException) {
            logger.info(e + ":发生系统负载");
            httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtil.error(HttpStatus.HTTP_BAD_GATEWAY, "系统负载异常")));
        } else {
            logger.error(e.toString());
        }
    }

}
