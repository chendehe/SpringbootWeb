package com.chendehe.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 *   通知：
 *     前置@Before、
 *     后置@After、
 *     返回@AfterReturning、
 *     异常@AfterThrowing、
 *     环绕@Around（动态代理，手动推进方法运行joinPoint.procced()）
 * @author CDH
 * @since 2019/7/30 19:34
 */
@Aspect
@Component
public class LogAspect {

  private static final String POINT = "execution(* com.chendehe.spring.aop.MyService.*(..))";
//  private static final String POINT = "execution (* com.chendehe.spring.aop.*.*(..))";
  // 可以抽取公共的切入点表达式
  // 1. 本类引用：@Before("pointCut()")
  // 2. 外部引用：@Before("com.chendehe.spring.aop.LogAspect.pointCut()")
  @Pointcut(POINT)
  public void pointCut() {
  }

  @Before("pointCut()")
  public void start() {
    System.out.println("Start");
  }

  @After("pointCut()")
  public void end() {
    System.out.println("End");
  }

  @AfterReturning("pointCut()")
  public void returnStart() {
    System.out.println("returnStart");
  }

  @AfterThrowing("pointCut()")
  public void exceptionStart() {
    System.out.println("exceptionStart");
  }

  @Around("pointCut()")
  public Object startAround(ProceedingJoinPoint joinPoint) {
    System.out.println("startAround..");
    try {
      Object proceed = joinPoint.proceed(joinPoint.getArgs());
      System.out.println("endAround..");
      return proceed;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    return null;
  }
}
