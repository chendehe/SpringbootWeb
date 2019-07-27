package com.chendehe.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "t_user")
public class UserEntity implements BaseEntity, Serializable {

  private static final long serialVersionUID = -2535178899662614143L;
  @Id
  @GeneratedValue
  private String id;
  private String name;
  private int gender;
  private LocalDate birthday;
  private String address;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
