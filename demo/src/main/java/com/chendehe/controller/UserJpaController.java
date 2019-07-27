package com.chendehe.controller;

import com.chendehe.dao.UserRepository;
import com.chendehe.exception.ResultUtil;
import com.chendehe.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserJpaController.class);

  private UserRepository repo;

  @Autowired
  public UserJpaController(UserRepository repo) {
    this.repo = repo;
  }

  /**
   * 查找列表. 成功返回200.
   */
  @GetMapping("/list")
  ResponseEntity findAll(Page page) {
    LOGGER.info("[UserController] id is:{}", page);
    return ResultUtil.success(repo.findAll(
        PageRequest.of(page.getCurrentPage(), page.getPageSize())), HttpStatus.OK);
  }

  /**
   * 查找详情. 成功返回200.
   */
  @GetMapping("/{id}")
  ResponseEntity findOne(@PathVariable String id) {
    LOGGER.info("[UserController] id is:{}", id);
    return ResultUtil.success(repo.findById(id), HttpStatus.OK);
  }

}