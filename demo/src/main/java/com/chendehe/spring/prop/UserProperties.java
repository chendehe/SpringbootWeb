package com.chendehe.spring.prop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 自定义配置样例.
 * 
 * @author CDH
 * @since 2019/7/27 16:10
 */
@Getter
@Setter
@ToString
@Component
//@ConfigurationProperties(prefix = "user")
@PropertySource(value = {"classpath:user.properties"})
public final class UserProperties {
    /**
     * 1. 赋值：""
     * 2. SPEL:#{}
     * 3. 配置文件：${}
     */
    @Value("name jack")
    private String name;

    @Value("${user.age}")
    private Integer age;

    @Value("#{'${user.username}'?.toUpperCase()}")
    private String username;

    @Value("${user.desc:default desc}")
    private String desc;
}
