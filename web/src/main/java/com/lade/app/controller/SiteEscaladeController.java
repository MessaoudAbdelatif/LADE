package com.lade.app.controller;

import dao.SiteEscaladeDao;
import entities.SiteEscalade;
import metier.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteEscaladeController {

  @Autowired
  private SiteEscaladeMetier siteEscaladeMetier;
  @Autowired
  private SiteEscaladeDao siteEscaladeDao;

  @GetMapping("/siteEscalade")
  public String siteEscalade(Model model,
      @RequestParam(name = "numPages", defaultValue = "0") int numPages,
      @RequestParam(name = "nomSiteEscaladeInsere", defaultValue = "") String sei) {
    try { Page<SiteEscalade> pagesiteEscalade = siteEscaladeDao
        .findByNomContains(sei, PageRequest.of(numPages, 5));
      model.addAttribute("siteEscalade", pagesiteEscalade.getContent());
      model.addAttribute("pages", new int[pagesiteEscalade.getTotalPages()]);
      model.addAttribute("nbrPagesTotal", new int[pagesiteEscalade.getTotalPages()].length);
      model.addAttribute("currentPage", numPages);
      model.addAttribute("sei", sei);
    }catch (Exception e){
      model.addAttribute("exceptionAucunSiteEscaladeTrouve", e);
    }


    return "views/siteEscalade";
  }

  @GetMapping("/viewSiteEscalade")
  public String viewSiteEscalade(Model model, String nom) {
    try {
      SiteEscalade se = siteEscaladeMetier.consulterSiteEscalade(nom);
      model.addAttribute("siteEscaladeSelected", se);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewSiteEscalade";
  }
  @GetMapping("/edit")
  public String modifierSiteEscalade(Model model,String nom){
    SiteEscalade se = siteEscaladeMetier.consulterSiteEscalade(nom);
    model.addAttribute("siteEscaladeSelected", se);
    return "/views/viewSiteEscalade";
  }
}
