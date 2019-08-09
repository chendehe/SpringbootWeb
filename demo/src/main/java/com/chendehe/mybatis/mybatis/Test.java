package com.chendehe.mybatis.mybatis;

import com.chendehe.mybatis.mybatis.mapper.User;
import com.chendehe.mybatis.mybatis.mapper.UserMapper;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author CDH
 * @since 2019.8.9 009 12:38
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 打开自动提交的 SqlSession
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.findById("111");
            System.out.println(user);
            System.out.println(mapper.findByUser(user));

        }
    }

}
