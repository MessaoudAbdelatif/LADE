package com.lade.app.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Bean
    //J'ajoute BCryptPasswordEncoder au contexte de Spring afin de l'injecter par la suite !
  BCryptPasswordEncoder getBCPE() {
    return new BCryptPasswordEncoder();
  }

  @Autowired  // J'injecte BCryptPasswordEncoder afin de l'utiliser dans les methods de la class pour crypter les mots de passes !
      BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    BCryptPasswordEncoder bpce = getBCPE();
    auth.jdbcAuthentication()
        .dataSource(dataSource) /*Set la DB concernée */
        .usersByUsernameQuery(
            "select username as principal, password as credentials, active from users where username=?") /*Requête SQL indiquant à Spring Security ou trouver le username  */
        .authoritiesByUsernameQuery(
            "select username as principal, role as role from users_roles where username=?") /*Requête SQL indiquant à Spring Security ou trouver les roles -> username  */
        .rolePrefix("ROLE_")
        .passwordEncoder(getBCPE()); /*Crypte le mdp avec Bcrypte*/
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage("/views/login")
        .loginProcessingUrl("/j_spring_security_check")
        .defaultSuccessUrl("/loginConfirme")
        .failureUrl("/login?error=true")
        .usernameParameter("username")//
        .passwordParameter("password");

    http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
    http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
    http.exceptionHandling().accessDeniedPage("/403");

  }
}

