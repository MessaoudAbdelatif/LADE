package com.lade.app.controller;


import entities.SiteEscalade;
import javax.validation.Valid;
import metier.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteEscaladeController {

  private SiteEscaladeMetier siteEscaladeMetier;


  @Autowired
  public SiteEscaladeController(
      SiteEscaladeMetier siteEscaladeMetier) {
    this.siteEscaladeMetier = siteEscaladeMetier;
  }

  @GetMapping("/siteEscalade")
  public String siteEscalade(Model model,
      @RequestParam(name = "numPages", defaultValue = "0") int numPages,
      @RequestParam(name = "nomSiteEscaladeInsere", defaultValue = "") String sei,
      @RequestParam(name = "typeRecherche", defaultValue = "NOM") String typeRecherche) {
    try {
      Page<SiteEscalade> pagesiteEscalade = siteEscaladeMetier
          .rechercherDesSitesEscalades(numPages, 5, sei, typeRecherche);
      model.addAttribute("siteEscalade", pagesiteEscalade.getContent());
      model.addAttribute("pages", new int[pagesiteEscalade.getTotalPages()]);
      model.addAttribute("nbrPagesTotal", new int[pagesiteEscalade.getTotalPages()].length);
      model.addAttribute("currentPage", numPages);
      model.addAttribute("currentTypeRecherche", typeRecherche);
      model.addAttribute("sei", sei);
    } catch (Exception e) {
      model.addAttribute("exceptionAucunSiteEscaladeTrouve", e);
    }

    return "views/siteEscalade";
  }

  @GetMapping("/viewSiteEscalade")
  public String afficherUnSiteEscalade(Model model, Long id) {
    try {
      SiteEscalade siteEscaladeSelected = siteEscaladeMetier.consulterUnSiteEscalade(id);
      model.addAttribute("siteEscaladeSelected", siteEscaladeSelected);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewSiteEscalade";
  }

  @GetMapping("/edit")
  public String modifierSiteEscalade(Model model, Long id) {
    SiteEscalade siteEscaladeSelected = siteEscaladeMetier.consulterUnSiteEscalade(id);
    model.addAttribute("siteEscaladeSelected", siteEscaladeSelected);
    return "views/modifierSiteEscalade";
  }

  @GetMapping("/creationSiteEscalade")
  public String creationSiteEscalade(Model model) {
    model.addAttribute("newSiteEscalade", new SiteEscalade());
    return "views/creationSiteEscalade";
  }

  @PostMapping("/saveSiteEscalade")
  public String saveCreationSiteEscalade(Model model,
      @Valid @ModelAttribute("newSiteEscalade") SiteEscalade siteEscalade,
      BindingResult newSiteEscaladeErrors) {
    if (newSiteEscaladeErrors.hasErrors()) {
      return "views/creationSiteEscalade";
    }
    siteEscaladeMetier.ajouterUnSiteEscalade(siteEscalade);
    return "redirect:/viewSiteEscalade?id=" +siteEscalade.getId();
  }

}
