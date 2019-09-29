package com.lade.app.controller;

import com.lade.app.dto.contract.SecteurMapperImpl;
import com.lade.app.dto.impl.SecteurDto;
import entities.Secteur;
import javax.validation.Valid;
import metier.contract.SecteurMetier;
import metier.contract.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecteurController {

  private final SecteurMetier secteurMetier;
  private final SiteEscaladeMetier siteEscaladeMetier;
  private final SecteurMapperImpl secteurMapper;

  private static final String VIEWS_CREATION_SECTEUR = "views/creationSecteur";

  @Autowired     // Annotation facultative (Injection via Constructeur)
  public SecteurController(SecteurMetier secteurMetier, SiteEscaladeMetier siteEscaladeMetier,
      SecteurMapperImpl secteurMapper
  ) {
    this.secteurMetier = secteurMetier;
    this.siteEscaladeMetier = siteEscaladeMetier;
    this.secteurMapper = secteurMapper;
  }
  //______________________________________________________________________________________

  //--------------------- Consulter un secteur en particulier ---------------

  @GetMapping("/viewSecteur/{id}")
  public String afficherUnSecteur(Model model, @PathVariable("id") Long id) {
    try {
      Secteur secteurSelected = secteurMetier.consulterUnSecteur(id);
      model.addAttribute("secteurSelected", secteurSelected);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewSecteur";
  }

  //___________________________________________________________________________
  //--------------------- Création d'Un Secteur -------------------------
  @ModelAttribute("newSecteur")
  public SecteurDto secteurDto() {
    return new SecteurDto();
  }

  @GetMapping("/creationSecteur/{siteEscaladeID}")
  public String creationSecteur(Model model,
      @PathVariable("siteEscaladeID") String siteEscaladeID) {
    model.addAttribute("idSiteEscalade", siteEscaladeID);
    model.addAttribute("SiteEscaladeParent",
        siteEscaladeMetier.consulterUnSiteEscalade(Long.valueOf(siteEscaladeID)));
    return VIEWS_CREATION_SECTEUR;
  }

  @PostMapping("/ajouterSecteur/{siteEscaladeID}")
  public String ajouterSecteur(Model model,
      @ModelAttribute("newSecteur") @Valid SecteurDto secteurDto, BindingResult newSecteurErrors,
      @PathVariable("siteEscaladeID") String siteEscaladeID) {
    model.addAttribute("SiteEscaladeParent",
        siteEscaladeMetier.consulterUnSiteEscalade(Long.valueOf(siteEscaladeID)));
    secteurDto.setSiteEscalade(siteEscaladeID);
    if (newSecteurErrors.hasErrors()) {
      return VIEWS_CREATION_SECTEUR;
    }

    secteurMetier.ajouterSecteur(secteurMapper
        .toSecteur(secteurDto));

    return "redirect:/viewSiteEscalade?id=" + siteEscaladeID;
  }
}