package com.lade.app.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{


  /**
   * @return a bean with the layoutDialect
   */
  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }


  @Override
  public void addResourceHandlers( ResourceHandlerRegistry registry ) {
    registry
        .addResourceHandler("/static/**")
        .addResourceLocations("classpath:/static/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("/webjars/");
  }


  private ISpringTemplateEngine templateEngine( ITemplateResolver templateResolver) {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.addDialect(new LayoutDialect(new GroupingStrategy()));
    engine.addDialect(new Java8TimeDialect());
    engine.setTemplateResolver(templateResolver);
    return engine;
  }
}
