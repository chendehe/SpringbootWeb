package com.chendehe.mybatis.spring;

import com.chendehe.mybatis.mybatis.mapper.User;
import com.chendehe.mybatis.mybatis.mapper.UserMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author CDH
 * @since 2019.8.9 009 16:03
 */
@Service
public class MyService {

    private SqlSessionTemplate sqlSession;
    private UserMapper userMapper;

    @Autowired
    MyService(SqlSessionTemplate sqlSession, UserMapper userMapper) {
        this.sqlSession = sqlSession;
        this.userMapper = userMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        System.out.println("START");
        userMapper.save(getUser());
        userMapper.save(getUser());
        System.out.println("END");
//        User user = getUser();
//        sqlSession.insert("com.chendehe.mybatis.mapper.UserMapper.save", user);
//        sqlSession.insert("com.chendehe.mybatis.mapper.UserMapper.save", user);
    }

    private User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("nnn");
        user.setGender(0);
        user.setBirthday(LocalDate.now());
        user.setAddress("rrrwqr");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return user;
    }
}
