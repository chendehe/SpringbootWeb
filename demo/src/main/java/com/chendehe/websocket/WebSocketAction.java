package com.chendehe.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketAction {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @MessageMapping("/sendTest")
  @SendTo("/queue/subscribeTest")
  public ServerMessage sendDemo(ClientMessage message) {
    logger.info("接收到消息" + message);
    return new ServerMessage(message.getName());
  }

  @SubscribeMapping("/subscribeTest")
  public ServerMessage sub() {
    logger.info("已订阅");
    return new ServerMessage("感谢订阅!");
  }

}