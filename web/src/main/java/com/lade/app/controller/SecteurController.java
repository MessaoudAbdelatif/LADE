package com.lade.app.controller;

import entities.Secteur;
import entities.SiteEscalade;
import javax.validation.Valid;
import metier.SecteurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecteurController {

  private SecteurMetier secteurMetier;

  @Autowired
  public SecteurController(SecteurMetier secteurMetier) {
    this.secteurMetier = secteurMetier;
  }

  @GetMapping("/creationSecteur")
  public String creationSecteur(Model model, @RequestParam(name = "nom") String nom) {
    model.addAttribute("secteur", new Secteur());
    model.addAttribute("nomSiteEscalade", nom);
    return "views/creationSecteur";
  }

  @PostMapping("/ajouterSecteur")
  public String ajouterSecteur(Model model,
      @Valid @ModelAttribute("secteur") Secteur secteur, @ModelAttribute("siteEscaladeParent") SiteEscalade siteEscalade,
      BindingResult newSecteurErrors) {
//    model.addAttribute("nomSiteEscalade", siteEscalade.getNom());
//   model.addAttribute("siteEscalade",siteEscalade);
    if (newSecteurErrors.hasErrors()) {
      return "views/creationSecteur";
    }
    siteEscalade.addSecteur(secteur);
    secteurMetier.ajouterSecteur(secteur);
    return "redirect:/viewSiteEscalade?nom=" + secteur.getSiteEscalade().getId();
  }
}
