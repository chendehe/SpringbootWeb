package com.chendehe.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVo {

  private String id;
  private String name;
  @JsonProperty("sex")
  private Integer gender;
  private LocalDate birthday;
  private String address;

}
