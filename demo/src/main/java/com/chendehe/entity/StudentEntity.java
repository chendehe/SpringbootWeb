package com.chendehe.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentEntity implements BaseEntity, Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String school;
  private String academy;
  private String major;
  private String classes;
  private Date createTime;
  private Date updateTime;

}
