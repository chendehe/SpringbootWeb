package com.chendehe.controller;

import com.chendehe.common.ErrorCode;
import com.chendehe.common.ErrorMessage;
import com.chendehe.exception.BaseException;
import com.chendehe.vo.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 拦截处理异常响应
 */
@RestControllerAdvice
public class ResponseHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity handle(Exception e) {
    if (e instanceof BaseException) {
      return new ResponseEntity<>(new ErrorResult(e.getMessage(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(new ErrorResult(ErrorMessage.message(ErrorCode.SYSTEM_ERROR), e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }
}
