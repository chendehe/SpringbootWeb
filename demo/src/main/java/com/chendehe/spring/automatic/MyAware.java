package com.chendehe.spring.automatic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * xxxAware：实现该接口，可以使用Spring底层的一些组件。
 * 在创建对象的时候，会调用接口规定的方法注入相关组件；把Spring底层的一些组件注入到自定义的Bean中。
 * 使用了 xxxProcessor 来实现。
 * 注入的时候 Aware 会回调执行:例如ApplicationContextAwareProcessor中
 *  private void invokeAwareInterfaces(Object bean) {
 *     if (bean instanceof Aware) {
 *       if (bean instanceof EnvironmentAware) {
 *         ((EnvironmentAware) bean).setEnvironment(this.applicationContext.getEnvironment());
 *            }
 *         if (bean instanceof EmbeddedValueResolverAware) {
 *         ((EmbeddedValueResolverAware) bean).setEmbeddedValueResolver(this.embeddedValueResolver);
 *         }
 *         if (bean instanceof ResourceLoaderAware) {
 *           ((ResourceLoaderAware) bean).setResourceLoader(this.applicationContext);
 *         }
 *         if (bean instanceof ApplicationEventPublisherAware) {
 *           ((ApplicationEventPublisherAware) bean).setApplicationEventPublisher(this.applicationContext);
 *         }
 *         if (bean instanceof MessageSourceAware) {
 *           ((MessageSourceAware) bean).setMessageSource(this.applicationContext);
 *         }
 *         if (bean instanceof ApplicationContextAware) {
 *           ((ApplicationContextAware) bean).setApplicationContext(this.applicationContext);
 *         }*
 *      }
 *   }
 * @author CDH
 * @since 2019/7/30 19:02
 */
@Component
public class MyAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("3. 设置上下文");
  }

  @Override
  public void setBeanName(String name) {
    System.out.println("1. 当前Bean的名称：" + name);
  }

  // 解析占位符
  @Override
  public void setEmbeddedValueResolver(StringValueResolver resolver) {
    String value = resolver.resolveStringValue("hello ${os.name}, #{2*6}");
    System.out.println("2. 字符串是：" + value);
  }
}
