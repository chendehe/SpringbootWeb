package com.chendehe.mybatis.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 注解方式：@Select("select * from t_user where id = #{id}")
     * 
     * 复杂 SQL 语句最好使用 XML 方式
     */
    User findById(String id);

    List<User> findByUser(User user);

    Map<String, Object> findMapById(String id);

    void save(User user);

    void saveBath(@Param("users") List<User> users);

    void updateById(User user);

    void deleteById(String id);
}