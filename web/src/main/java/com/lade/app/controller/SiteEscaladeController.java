package com.lade.app.controller;

import dao.SiteEscaladeDao;
import entities.SiteEscalade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteEscaladeController {

  @Autowired
  private SiteEscaladeDao siteEscaladeDao;

  @GetMapping("/siteEscalade")
  public String siteEscalade(Model model) {
    List<SiteEscalade> siteEscalade = siteEscaladeDao.findAll();
    model.addAttribute("listSiteEscalade", siteEscalade);

    return "views/siteEscalade";
  }
}
