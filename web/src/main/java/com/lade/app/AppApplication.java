package com.lade.app;

import dao.SiteEscaladeDao;
import entities.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"dao"})
@EntityScan(basePackages = {"entities"})
public class AppApplication implements CommandLineRunner {
@Autowired
  private SiteEscaladeDao siteEscaladeDao;
  public static void main(String[] args) {
    SpringApplication.run(AppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
siteEscaladeDao.save(new SiteEscalade("Les Calanques","abc","def"));
    siteEscaladeDao.save(new SiteEscalade("Les Calanques de Toulon","abc2","def2"));
    siteEscaladeDao.save(new SiteEscalade("Les Calanques de Nice","abc3","def3"));
  siteEscaladeDao.findAll().forEach(s->{
    System.out.println(s.getNom());
  });
  }
}