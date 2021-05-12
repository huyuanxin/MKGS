package org.graduation.knowledge.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

/**
 * @author huyuanxin
 */
@Aspect
@Component
public class LoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Before(value = "execution(* org.graduation.knowledge..controller..*(..))")
    public void doBeforeController(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = Objects.requireNonNull(servletRequestAttributes).getRequest();
        StringBuffer requestUrl = servletRequest.getRequestURL();
        String logInfo = "\n" + "请求路径=" + requestUrl + "\n" +
                "请求ip地址=" + servletRequest.getRemoteAddr() + "\n" +
                "请求的类名=" + joinPoint.getSignature().getDeclaringTypeName() + "\n" +
                "请求的方法名=" + joinPoint.getSignature().getName() + "\n" +
                "请求时间=" + new Date();
        logger.info(logInfo);
    }
}
