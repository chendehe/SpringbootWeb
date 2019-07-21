package com.chendehe.dao;

import com.chendehe.entity.StudentEntity;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class StudentDaoProvider {

  public String saveBatch(Map<String, List<StudentEntity>> map) {
    List<StudentEntity> list = map.get("list");
    StringBuilder sb = new StringBuilder();
    sb.append("insert into t_student ");
    sb.append("(id, school, academy, major, classes, create_time, update_time) ");
    sb.append("values ");
    MessageFormat mf = new MessageFormat("#'{'id'}', #'{'school'}', #'{'academy'}', " +
        "#'{'major'}', #'{'classes'}', #'{'create_time'}', #'{'updateTime'}'");
    for (int i = 0; i < list.size(); i++) {
      sb.append(mf.format(new Object[]{i}));
      if (i < list.size() - 1) {
        sb.append(",");
      }
    }
    return sb.toString();
  }


}
