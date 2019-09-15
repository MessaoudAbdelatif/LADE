package com.lade.app.controller;

import com.lade.app.dto.contract.VoieMapperImpl;
import com.lade.app.dto.impl.VoieDto;
import entities.Cotation;
import entities.Voie;
import javax.validation.Valid;
import metier.contract.SecteurMetier;
import metier.contract.VoieMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class VoieController {

  private VoieMetier voieMetier;
  private VoieMapperImpl voieMapper;
  private SecteurMetier secteurMetier;

  @Autowired
  public VoieController(VoieMetier voieMetier, VoieMapperImpl voieMapper,
      SecteurMetier secteurMetier) {
    this.voieMetier = voieMetier;
    this.voieMapper = voieMapper;
    this.secteurMetier = secteurMetier;
  }

  //--------------------- Consulter une Voie ---------------------------------

  @GetMapping("/viewVoie/{id}")
  public String afficherUneVoie(Model model, @PathVariable("id") Long id) {
    try {
      Voie voieSelected = voieMetier.consulterUneVoie(id);
      model.addAttribute("voieSelected", voieSelected);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewVoie";
  }

  //___________________________________________________________________________
  //--------------------- Création d'Une Voie -------------------------
  @ModelAttribute("newVoie")
  public VoieDto voieDto() {
    return new VoieDto();
  }

  @GetMapping("/creationVoie/{secteurID}")
  public String creationVoie(Model model, @PathVariable("secteurID") String secteurID) {
    model.addAttribute("secteurID", secteurID);
    model.addAttribute("SecteurParent", secteurMetier.consulterUnSecteur(Long.valueOf(secteurID)));
    model.addAttribute("cotationList", Cotation.getCotations());
    return "views/creationVoie";
  }

  @PostMapping("/ajouterVoie/{secteurID}")
  public String ajouterVoie(Model model,
      @Valid @ModelAttribute("newVoie") VoieDto voieDto, BindingResult newVoieErrors,
      @ModelAttribute("secteurID") String secteurID) {
    model.addAttribute("SecteurParent", secteurMetier.consulterUnSecteur(Long.valueOf(secteurID)));
    voieDto.setSecteur(secteurID);
    if (newVoieErrors.hasErrors()) {
      return "views/creationVoie";
    }
    voieMetier.ajouterVoie(voieMapper.toVoie(voieDto));

    return "redirect:/viewSecteur/" + secteurID;
  }
}
