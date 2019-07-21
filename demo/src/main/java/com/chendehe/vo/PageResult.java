package com.chendehe.vo;

import java.util.List;
import org.springframework.core.style.ToStringCreator;

public class PageResult<T> extends Page {

  // 总数
  private Integer totalNum;

  private List<T> list;

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public List getList() {
    return list;
  }

  public void setList(List list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this).toString();
  }
}
