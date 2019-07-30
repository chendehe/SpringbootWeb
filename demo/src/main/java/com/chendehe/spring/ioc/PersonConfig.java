package com.chendehe.spring.ioc;

import java.io.IOException;
import java.util.Set;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 包扫描、过滤器
 * @author CDH
 * @since 2019/7/30 14:53
 */
// 导入第三方类，id默认是全类名
// 可以实现ImportSelector、ImportBeanDefinitionRegistrar，自定义导入的组件规则
@Import({Color.class, MyImport.class, MyImportBean.class})
@Configuration
// 扫描路径
@ComponentScan(value = "com.chendehe.spring.ioc", excludeFilters = {
    // 排除掉@Controller注解类
//    @Filter(type = FilterType.ANNOTATION, classes = Controller.class)
    // 排除掉BookService类型，包括他的子类、实现类
//    @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookService.class)
    // 不常用，ASPECTJ表达式
//    @Filter(type = FilterType.ASPECTJ, classes = Controller.class)
    // 正则表达式，排除后缀为2Controller
//    @Filter(type = FilterType.REGEX, pattern = {"..*2Controller"})
    // 自定义规则，需要实现 TypeFilter
//    @Filter(type = FilterType.CUSTOM, classes = MyType.class)
}/*, useDefaultFilters = false*/)
// 可以配置多个@ComponentScan规则
//@ComponentScan(value = "com.chendehe.spring.ioc.service", includeFilters = {
//    // 只注入@Controller注解类
//    @Filter(type = FilterType.ANNOTATION, classes = Controller.class)
//}, useDefaultFilters = false)
public class PersonConfig {

  // 满足条件时注入，可以自定义条件
  @Conditional(MyCondition.class)
  // 懒加载，容器启动不创建，在第一次使用时创建
  @Lazy
// ConfigurableBeanFactory#SCOPE_PROTOTYPE 多实例
// ConfigurableBeanFactory#SCOPE_SINGLETON 默认单实例
// org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
// org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
  @Scope
  // 给容器注册一个Bean，id默认是方法名。
  @Bean
  Person getPerson() {
    return new Person("haha", 12);
  }

  @Bean
  CarFactoryBean carBean() {
    return new CarFactoryBean();
  }
}
class MyType implements TypeFilter {

  /**
   *
   * @param metadataReader 读到的当前扫描到的类
   * @param metadataReaderFactory 可以获取其他任何类的信息
   * @return
   * @throws IOException
   */
  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
    // 获取当前类注解。
    AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
    // 类信息
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    String className = classMetadata.getClassName();
    System.out.println("--->"+className);
    // 类路径等资源信息
    Resource resource = metadataReader.getResource();
    return className.contains("Cont");
  }
}
class MyCondition implements Condition {

  /**
   *
   * @param context 上下文环境
   * @param metadata 注解信息
   * @return
   */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Environment env = context.getEnvironment();
    String osName = env.getProperty("os.name");
    System.out.println("osName:"+osName);
    return osName.contains("Windows");
  }
}

//自定义返回需要的组件
class MyImport implements ImportSelector {

  /**
   *
   * @param metadata 当前标注@Import的类的所有注解信息
   * @return
   */
  @Override
  public String[] selectImports(AnnotationMetadata metadata) {
    Set<String> annotationTypes = metadata.getAnnotationTypes();
    for (String type : annotationTypes) {
      System.out.println("===>"+type);
    }
//  全部放行  return new String[0];
    // 全类名
    return new String[]{"com.chendehe.spring.ioc.Yello", "com.chendehe.spring.ioc.Blue"};
  }
}
class MyImportBean implements ImportBeanDefinitionRegistrar {

  /**
   *
   * @param metadata 当前类的所有注解信息
   * @param registry BeanDefinition注册类
   */
  @Override
  public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    boolean yello = registry.containsBeanDefinition("com.chendehe.spring.ioc.Yello");
    System.out.println("registerBeanDefinitions:" + yello);
    // 手工注册Bean
    BeanDefinition beanDefinitions = new RootBeanDefinition(Red.class);
    registry.registerBeanDefinition("myRed", beanDefinitions);
  }
}