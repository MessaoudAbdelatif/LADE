package com.lade.app.controller;


import entities.Secteur;
import entities.SiteEscalade;
import javax.validation.Valid;
import metier.SecteurMetier;
import metier.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteEscaladeController {

  private SiteEscaladeMetier siteEscaladeMetier;
  private SecteurMetier secteurMetier;

  @Autowired
  public SiteEscaladeController(
      SiteEscaladeMetier siteEscaladeMetier, SecteurMetier secteurMetier) {
    this.siteEscaladeMetier = siteEscaladeMetier;
    this.secteurMetier = secteurMetier;
  }

  @GetMapping("/siteEscalade")
  public String siteEscalade(Model model,
      @RequestParam(name = "numPages", defaultValue = "0") int numPages,
      @RequestParam(name = "nomSiteEscaladeInsere", defaultValue = "") String sei,
      @RequestParam(name = "typeRecherche", defaultValue = "NOM") String typeRecherche) {
    try {
      Page<SiteEscalade> pagesiteEscalade = siteEscaladeMetier
          .rechercherUnSiteEscalade(numPages, 5, sei, typeRecherche);
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
  public String modifierSiteEscalade(Model model, String nom) {
    SiteEscalade se = siteEscaladeMetier.consulterSiteEscalade(nom);
    model.addAttribute("siteEscaladeSelected", se);
    return "/views/viewSiteEscalade";
  }

  @GetMapping("/creationSiteEscalade")
  public String creationSiteEscalade(Model model) {
    model.addAttribute("siteEscalade", new SiteEscalade());
    return "views/creationSiteEscalade";
  }

  @PostMapping("/saveSiteEscalade")
  public String saveSiteEscalade(Model model,
      @Valid SiteEscalade siteEscalade,
      BindingResult newSiteEscaladeErrors) {
    if (newSiteEscaladeErrors.hasErrors()) {
      return "views/creationSiteEscalade";
    }
      siteEscaladeMetier.ajouterUnSiteEscalade(siteEscalade);
      return "redirect:/viewSiteEscalade?nom="+ siteEscalade.getNom();
    }
    @GetMapping("/creationSecteur")
    public String creationSecteur(Model model, SiteEscalade siteEscalade){
    model.addAttribute("secteur",new Secteur());
    model.addAttribute("nomSiteEscalade", siteEscalade.getNom());
    return "views/creationSecteur";
    }

  @PostMapping("/ajouterSecteur")
  public String ajouterSecteur(Model model,
      @Valid Secteur secteur,
      BindingResult newSecteurErrors, SiteEscalade siteEscalade) {
    model.addAttribute("nomSiteEscalade",siteEscalade.getNom());
    if (newSecteurErrors.hasErrors()) {
      return "views/creationSecteur";
    }
   secteurMetier.ajouterSecteur(secteur);
    return "redirect:/viewSiteEscalade?nom="+ siteEscalade.getNom();
  }
}
