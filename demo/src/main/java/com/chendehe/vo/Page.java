package com.chendehe.vo;

import org.springframework.core.style.ToStringCreator;

public class Page {

  // 当前页
  private Integer currentPage;

  // 页面大小
  private Integer pageSize;

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public String toString() {
    return new ToStringCreator(this).toString();
  }
}
