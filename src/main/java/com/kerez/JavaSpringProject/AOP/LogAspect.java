package com.kerez.JavaSpringProject.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(Loggable)")
    public void callAtMyServiceAnnotation() {
    }


    @Around("callAtMyServiceAnnotation()")
    public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        logger.info("Call method " + methodName + " with args " + methodArgs);

        Object result = thisJoinPoint.proceed();

        logger.info("Method " + methodName + " returns " + result);

        return result;
    }
}
