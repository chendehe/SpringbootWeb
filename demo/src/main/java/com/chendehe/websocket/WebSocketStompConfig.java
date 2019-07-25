package com.chendehe.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

  /**
   * 注册stomp的端点.
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    // 在网页上我们就可以通过这个链接
    // http://localhost:1111/webSocketServer
    // 来和服务器的WebSocket连接
    registry.addEndpoint("/webSocketServer").setAllowedOrigins("*").withSockJS();
  }

  /**
   * 配置信息代理.
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    // 订阅Broker名称
    registry.enableSimpleBroker("/queue", "/topic");
    // 全局使用的消息前缀（客户端订阅路径上会体现出来）
    registry.setApplicationDestinationPrefixes("/app");
  }

}