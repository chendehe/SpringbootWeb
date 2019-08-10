package com.chendehe.mybatis.spring;

import com.chendehe.mybatis.mybatis.mapper.User;
import com.chendehe.mybatis.mybatis.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author CDH
 * @since 2019.8.9 009 17:41
 */
@ComponentScan("com.chendehe.mybatis")
@MapperScan("com.chendehe.mybatis.mybatis")
public class Test {

    private static UserMapper mapper;

    public Test(UserMapper mapper) {
        Test.mapper = mapper;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Test.class);
//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
        User user = mapper.findById("111");
        System.out.println(user);
    }
}
