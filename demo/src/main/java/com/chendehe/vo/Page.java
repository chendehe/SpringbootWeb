package com.chendehe.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Page {

  // 当前页
  private Integer currentPage;

  // 页面大小
  private Integer pageSize;

}
