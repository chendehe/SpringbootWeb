//package com.chendehe.config.redis;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
///**
// * Lettuce 配置信息,默认方式.
// */
//@Configuration
//public class LettuceConfig {
//
//  /**
//   * Redis 单机.
//   */
//  @Bean
//  @ConditionalOnProperty(value = "spring.redis.host")
//  @ConfigurationProperties(prefix = "spring.redis")
//  public RedisConnectionFactory connectionFactory() {
//    return new LettuceConnectionFactory(new RedisStandaloneConfiguration());
//  }
//
//  @Bean
//  public RedisTemplate redisTemplate() {
//    RedisTemplate<String, String> template = new RedisTemplate<>();
//    template.setConnectionFactory(connectionFactory());
//
//    // 指定键值的序列化方式
//    RedisSerializer<String> serializer = RedisSerializer.string();
//    template.setKeySerializer(RedisSerializer.string());
//    template.setValueSerializer(serializer);
//    // 是否启用事务，默认 false，启用时类上需要增加注解 @EnableTransactionManagement
//    template.setEnableTransactionSupport(false);
//    return template;
//  }
//
//  @Bean
//  public StringRedisTemplate stringRedisTemplate() {
//    return new StringRedisTemplate(connectionFactory());
//  }
//
//  /**
//   * 支持 Redis 集群.
//   * havingValue 默认为 ”true“
//   */
//  @Bean
//  @ConditionalOnProperty(value = "spring.redis.cluster.enable", havingValue = "true")
//  @ConfigurationProperties(prefix = "spring.redis.cluster")
//  public RedisConnectionFactory clusterConnectionFactory() {
//    return new LettuceConnectionFactory(new RedisClusterConfiguration());
//  }
//
//  /**
//   * 支持 Redis 哨兵.
//   */
//  @Bean
//  @ConditionalOnProperty(value = "spring.redis.sentinel.master")
//  @ConfigurationProperties(prefix = "spring.redis.sentinel.master")
//  public RedisConnectionFactory sentinelConnectionFactory() {
//    return new LettuceConnectionFactory(new RedisSentinelConfiguration());
//  }
//
////  /**
////   * 读写分离配置.
////   */
////  @Bean
////  @ConfigurationProperties(prefix = "spring.redis.host")
////  public RedisConnectionFactory masterSlaveConnectionFactory() {
////
////    LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
////        .readFrom(ReadFrom.SLAVE_PREFERRED)
////        .build();
////
////    RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration();
////
////    return new LettuceConnectionFactory(serverConfig, clientConfig);
////  }
//}
