package com.chendehe.controller;

import com.chendehe.exception.ResultUtil;
import com.chendehe.kafka.KafkaService;
import com.chendehe.kafka.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CDH
 * @since 2019/7/27 16:42
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

  private KafkaService kafkaService;

  public KafkaController(KafkaService kafkaService) {
    this.kafkaService = kafkaService;
  }

  @PostMapping
  public ResponseEntity produce(@RequestBody Message msg) {
    return ResultUtil.success(kafkaService.produce(msg), HttpStatus.CREATED);
  }

}
