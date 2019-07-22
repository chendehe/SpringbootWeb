//package com.chendehe.config.redis;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.spring.starter.RedissonAutoConfiguration;
//import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Component;
//
///**
// * Redisson 配置信息.
// */
//@Configuration
//public class RedissonConfig {
//
//  /**
//   * Redis.
//   */
//  @Bean
//  public RedissonClient client() {
//    return Redisson.create(new Config());
//  }
//
//}
