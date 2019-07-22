package com.chendehe.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity implements BaseEntity, Serializable {

  private static final long serialVersionUID = -2535178899662614143L;
  private String id;
  private String name;
  private int gender;
  private LocalDate birthday;
  private String address;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
