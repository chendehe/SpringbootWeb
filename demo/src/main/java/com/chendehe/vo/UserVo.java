package com.chendehe.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.springframework.core.style.ToStringCreator;

public class UserVo {

  private String id;
  private String name;
  @JsonProperty("sex")
  private Integer gender;
  private Date birthday;
  private String address;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this).toString();
  }
}
