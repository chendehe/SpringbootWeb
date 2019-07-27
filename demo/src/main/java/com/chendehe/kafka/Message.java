package com.chendehe.kafka;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author CDH
 * @since 2019/7/27 16:58
 */
@Getter
@Setter
@ToString
public class Message {
  private String topic;
  private String msg;
}
