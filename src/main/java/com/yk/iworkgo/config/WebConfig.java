package com.yk.iworkgo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 */
@Configuration
@ComponentScan
//@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport {
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
      //注：ResourceUtils.CLASSPATH_URL_PREFIX就是"classpath:",如果不加这个，就会提示找不到资源
      super.addResourceHandlers(registry);
  }

  //  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    /**
//     * 处理所有HTML的请求，到static目录下查找对应的资源
//     */
//    registry.addResourceHandler("/**") //处理的路径规则
//            .addResourceLocations("classpath:/templates/")  //到哪些目录下去查找静态资源
//    ;
//  }
//
//  @Override
//  public void configureViewResolvers(ViewResolverRegistry registry) {
//    /**
//     * 添加HTML的视图解析器
//     * 本示例完成以下功能：将Controller返回的String类型的视图名称添加前缀及后缀；
//     * 如返回的是a，那么处理后对应的视图将会是/a.html
//     */
//    registry.viewResolver(new InternalResourceViewResolver("/", ".html"));
//  }
}
