package com.lade.app.controller;

import com.lade.app.dto.SecteurDto;
import entities.Secteur;
import entities.SiteEscalade;
import javax.validation.Valid;
import metier.SecteurMetier;
import metier.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecteurController {

  private SecteurMetier secteurMetier;
  private SiteEscaladeMetier siteEscaladeMetier;
  @Autowired
  public SecteurController(SecteurMetier secteurMetier, SiteEscaladeMetier siteEscaladeMetier) {
    this.secteurMetier = secteurMetier;
    this.siteEscaladeMetier = siteEscaladeMetier;
  }

  @GetMapping("/creationSecteur")
  public String creationSecteur(Model model,  Long id) {
    model.addAttribute("newSecteur", new SecteurDto());
    model.addAttribute("idSiteEscalade", id);
    model.addAttribute("SiteEscaladeParent",siteEscaladeMetier.consulterUnSiteEscalade(id));
    return "views/creationSecteur";
  }

  @PostMapping("/ajouterSecteur")
  public String ajouterSecteur(Model model,
      @Valid @ModelAttribute("newSecteur") Secteur secteur, @ModelAttribute("SiteEscaladeParent") SiteEscalade siteEscalade,
      BindingResult newSecteurErrors) {
//    model.addAttribute("nomSiteEscalade", siteEscalade.getNom());
//   model.addAttribute("siteEscalade",siteEscalade);
    if (newSecteurErrors.hasErrors()) {
      return "views/creationSecteur";
    }
//    siteEscalade.addSecteur(secteur);
    secteurMetier.ajouterSecteur(secteur);
    return "redirect:/viewSiteEscalade?nom=" + siteEscalade.getId();
  }
}
