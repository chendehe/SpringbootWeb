package com.chendehe.dao;

import com.chendehe.entity.StudentEntity;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentDao extends BaseDao {

  @Select("select * from t_student")
  List<StudentEntity> findAll();

  //StudentEntity findOne(String id);

  @Insert("insert into t_student(id, school, academy, major, classes, create_time, update_time) " +
      "values(#{id}, #{school}, #{academy}, #{major}, #{classes}, #{create_time}, #{updateTime})")
  void save(StudentEntity student);

  @InsertProvider(value = StudentDaoProvider.class, method = "saveBatch")
  void saveBatch(@Param("list") List<StudentEntity> student);

  //void update(StudentEntity student);
  //void delete(String id);
  //int totalNum();
}
