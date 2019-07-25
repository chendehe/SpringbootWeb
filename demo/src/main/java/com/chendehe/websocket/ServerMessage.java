package com.chendehe.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 服务端消息实体.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ServerMessage {
  private String responseMessage;


}