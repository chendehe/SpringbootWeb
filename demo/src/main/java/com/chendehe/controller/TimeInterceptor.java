package com.chendehe.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeInterceptor {

  private static final Logger LOGGER = LoggerFactory.getLogger(TimeInterceptor.class);

  private static final String POINT = "execution (* com.chendehe.controller.*.*(..))";

  /**
   * 统计方法执行耗时Around环绕通知.
   */
  @Around(POINT)
  public Object timeAround(ProceedingJoinPoint joinPoint) {

    Object obj = null;
    long startTime = System.currentTimeMillis();

    try {
      obj = joinPoint.proceed(joinPoint.getArgs());
    } catch (Throwable e) {
      LOGGER.error("Statistical running time error", e);
    }

    long endTime = System.currentTimeMillis();
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String typeName = signature.getDeclaringTypeName();
    String name = signature.getName();
    String methodName = typeName.substring(typeName.lastIndexOf(".") + 1) + "." + name;

    // 打印耗时的信息
    long totalTime = endTime - startTime;
    if (totalTime > 100) {
      LOGGER.warn("***Method:" + methodName + " took " + totalTime + " ms");
    }

    return obj;
  }


}