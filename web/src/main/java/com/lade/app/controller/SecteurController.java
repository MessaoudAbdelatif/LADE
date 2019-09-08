package com.lade.app.controller;

import com.lade.app.dto.SecteurDto;
import com.lade.app.dto.SecteurMapperImpl;
import entities.Secteur;
import javax.validation.Valid;
import metier.SecteurMetier;
import metier.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecteurController {

  private SecteurMetier secteurMetier;
  private SiteEscaladeMetier siteEscaladeMetier;
  private SecteurMapperImpl secteurMapper;

  @Autowired     // Annotation facultative (Injection via Constructeur)
  public SecteurController(SecteurMetier secteurMetier, SiteEscaladeMetier siteEscaladeMetier
      , SecteurMapperImpl secteurMapper
  ) {
    this.secteurMetier = secteurMetier;
    this.siteEscaladeMetier = siteEscaladeMetier;
    this.secteurMapper = secteurMapper;
  }
//______________________________________________________________________________________

  //--------------------- Consulter un secteur en particulier ---------------

  @GetMapping("/viewSecteur/{id}")
  public String afficherUnSecteur(Model model,@PathVariable("id") Long id) {
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
  @GetMapping("/creationSecteur")
  public String creationSecteur(Model model,  @RequestParam (name = "id")Long id) {
    model.addAttribute("newSecteur", new SecteurDto(Long.toString(id)));
    model.addAttribute("idSiteEscalade", id);
    model.addAttribute("SiteEscaladeParent",siteEscaladeMetier.consulterUnSiteEscalade(id));
    return "views/creationSecteur";
  }

  @PostMapping("/ajouterSecteur")
  public String ajouterSecteur(Model model,
      @Valid @ModelAttribute("newSecteur") SecteurDto secteurDto,BindingResult newSecteurErrors,@ModelAttribute("idSiteEscalade") String id) {

    if (newSecteurErrors.hasErrors()) {
      return "views/creationSecteur";
    }

   Secteur newSecteur = secteurMapper.toSecteur(secteurDto);      // Mapping DTO form into JPA Entity
    secteurMetier.ajouterSecteur(newSecteur);

    return "redirect:/siteEscalade";
  }
}
