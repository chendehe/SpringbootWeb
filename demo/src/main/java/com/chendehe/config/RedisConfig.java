package com.chendehe.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Redis 配置信息.
 */
@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "redis")
@PropertySource("classpath:redis.properties")
public class RedisConfig {

  private String host;

  private int port;

}
