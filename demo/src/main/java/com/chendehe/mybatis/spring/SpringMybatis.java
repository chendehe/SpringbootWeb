package com.chendehe.mybatis.spring;

import com.chendehe.mybatis.mybatis.mapper.User;
import com.chendehe.mybatis.mybatis.mapper.UserMapper;
import java.io.IOException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author CDH
 * @since 2019.8.9 009 12:38
 */
@ComponentScan("com.chendehe.mybatis")
@EnableTransactionManagement
public class SpringMybatis {

    private static SqlSessionTemplate sqlSession;

    private static UserDaoImpl userDao;

    private static MyService service;

    private static UserMapper userMapper;

    @Autowired
    SpringMybatis(SqlSessionTemplate sqlSession, UserDaoImpl userDao, MyService service, UserMapper userMapper) {
        SpringMybatis.sqlSession = sqlSession;
        SpringMybatis.userDao = userDao;
        SpringMybatis.service = service;
        SpringMybatis.userMapper = userMapper;
    }

    public static void main(String[] args) throws IOException {
        new AnnotationConfigApplicationContext(SpringMybatis.class);
        User user = sqlSession.selectOne("com.chendehe.mybatis.mybatis.mapper.UserMapper.findById", "111");
        System.out.println(user);

        User byId = userDao.findById("111");
        System.out.println(byId);

        System.out.println(userMapper.findById("111"));
//        service.save();
    }

}
