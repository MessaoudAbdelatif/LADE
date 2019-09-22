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
            "select username as principal, mot_de_pass as credentials, etat_compte from utilisateur_connecte where username=?") /*Requête SQL indiquant à Spring Security ou trouver le username  */
        .authoritiesByUsernameQuery(
            "select username as principal, role as role from utilisateur_connecte_roles inner join role on utilisateur_connecte_roles.role_id = id where username=?") /*Requête SQL indiquant à Spring Security ou trouver les roles -> username  */
        .rolePrefix("ROLE_")
        .passwordEncoder(getBCPE()); /*Crypte le mdp avec Bcrypte*/
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage("/login")
        .permitAll()
        .defaultSuccessUrl("/loginConfirme")
        .failureUrl("/login?error=true")
     /*   .usernameParameter("username")//
        .passwordParameter("password")*/
        .and()
        .logout().permitAll().logoutSuccessUrl("/logoutConfirme");



    http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
    http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
    http.exceptionHandling().accessDeniedPage("/403");

  }
}

