package com.chendehe.config;

import com.chendehe.util.PropertieUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 使用@ConfigurationProperties 获取配置文件内容 也可以用@Value 给每个属性逐个注入 或者使用工具类直接获取配置.
 *
 * @see PropertieUtil
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "aaa")
@PropertySource("classpath:config/template.properties")
public class PropertieConfig {

  private String test1;

  private String test2;

}
