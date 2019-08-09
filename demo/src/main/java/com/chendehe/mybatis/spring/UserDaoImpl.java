package com.chendehe.mybatis.spring;

import com.chendehe.mybatis.mybatis.mapper.User;
import com.chendehe.mybatis.mybatis.mapper.UserMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserMapper {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public User findById(String id) {
        return getSqlSession().selectOne("com.chendehe.mybatis.mybatis.mapper.UserMapper.findById", id);
    }

    @Override
    public List<User> findByUser(User user) {
        return null;
    }

    @Override
    public Map<String, Object> findMapById(String id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void saveBath(List<User> users) {

    }

    @Override
    public void updateById(User user) {

    }

    @Override
    public void deleteById(String id) {

    }
}