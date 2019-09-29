/**
 * app classes used to produce LADE application entry point.
 * <p>
 * These classes contain:the entry point, Spring Annotations.
 * </p>
 *
 * @since 1.0
 * @author ABDELATIF
 * @version 1.0
 */

package com.lade.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"dao"})
@EntityScan(basePackages = {"entities"})
//POA cherche les annotations Spring (@Controller et @Service)
@ComponentScan(basePackages = {"metier", "com"})

public class AppApplication {

  /**
   * Entry point.
   * @param args no specifique args needed.
   */
  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }


}
