package com.chendehe.dao;

import com.chendehe.entity.UserEntity;
import com.chendehe.vo.Page;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao extends BaseDao {

  @Select("select * from t_user limit 0, 10")
  List<UserEntity> findAll(Page page);

  @Select("select * from t_user where id = #{id}")
  Optional<UserEntity> findOne(String id);

  @Insert("insert into t_user(id, name, gender, birthday, address, create_time, update_time) " +
      "values(#{id}, #{name}, #{gender}, #{birthday}, #{address}, #{createTime}, #{updateTime})")
  void save(UserEntity user);

  @Insert("<script> " +
      "insert into t_user(id, name, gender, birthday, address, create_time, update_time) " +
      "values " +
      "<foreach collection=\"items\" index=\"index\" item=\"item\" separator=\",\"> " +
      "(#{id}, #{name}, #{gender}, #{birthday}, #{address}, #{createTime}, #{updateTime})" +
      "</foreach> " +
      "</script>")
  void saveBatch(List<UserEntity> user);

  @Update("update t_user set name = #{name}, gender = #{gender}, birthday = #{birthday}, " +
      "address = #{address}, update_time = #{updateTime} where id = #{id}")
  void update(UserEntity user);

  @Delete("delete from t_user where id = #{id}")
  void delete(String id);

  @Select("select count(*) from t_user")
  int totalNum();
}
