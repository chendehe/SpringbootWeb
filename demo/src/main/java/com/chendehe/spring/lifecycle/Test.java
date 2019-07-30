package com.chendehe.spring.lifecycle;

import com.chendehe.spring.ioc.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 生命周期 --> Bean的创建-初始化-销毁
 * 可以自定义初始化和销毁方法
 * 1. 在 @Bean 指定方法（多实例时，在获取时初始化，但是不会调用销毁方法）
 * 2. 实现接口InitializingBean\DisposableBean
 * 3. JSR250-@PostConstruct：Bean创建完成，属性初始化完成；@PreDestroy：Bean被移除前；Bean销毁之前
 * 4. BeanPostProcessor-后置处理器。需要注入容器，这样每个组件初始化前后都会执行。
 * @author CDH
 * @since 2019/7/30 16:42
 */
public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCylceConfig.class);

    context.close();// 容器关闭时销毁
  }
}
