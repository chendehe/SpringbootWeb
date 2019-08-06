package com.chendehe.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 测试事务
 *
 * @author CDH
 * @since 2019/7/30 19:32
 */
@Configuration
@ComponentScan("com.chendehe.spring.listener")
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);

        // 发布事件
        context.publishEvent(new ApplicationEvent("my event") {});

    }

}
