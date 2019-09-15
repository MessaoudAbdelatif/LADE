package com.lade.app.controller;

import com.lade.app.dto.contract.LongeurMapperImpl;
import com.lade.app.dto.impl.LongeurDto;
import entities.Cotation;
import entities.Longeur;
import javax.validation.Valid;
import metier.contract.LongeurMetier;
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
public class LongeurController {

  private LongeurMetier longeurMetier;
  private VoieMetier voieMetier;
  private LongeurMapperImpl longeurMapper;

  @Autowired
  public LongeurController(LongeurMetier longeurMetier, VoieMetier voieMetier,
      LongeurMapperImpl longeurMapper) {
    this.longeurMetier = longeurMetier;
    this.voieMetier = voieMetier;
    this.longeurMapper = longeurMapper;
  }

  //--------------------- Consulter une Longeur en particulier ---------------

  @GetMapping("/viewLongeur/{id}")
  public String afficherUneLongeur(Model model, @PathVariable("id") Long id) {
    try {
      Longeur longeurSelected = longeurMetier.consulterUneLongeur(id);
      model.addAttribute("longeurSelected", longeurSelected);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewLongeur";
  }

  //___________________________________________________________________________

  //--------------------- Création d'Une Longeur -------------------------
  @ModelAttribute("newLongeur")
  public LongeurDto longeurDto() {
    return new LongeurDto();
  }


  @GetMapping("/creationLongeur/{voieID}")
  public String creationLongeur(Model model, @PathVariable("voieID") String id) {
    model.addAttribute("voieID", id);
    model.addAttribute("VoieParent", voieMetier.consulterUneVoie(Long.valueOf(id)));
    model.addAttribute("cotationList", Cotation.getCotations());
    return "views/creationLongeur";
  }

  @PostMapping("/ajouterLongeur/{voieID}")
  public String ajouterLongeur(Model model,
      @Valid @ModelAttribute("newLongeur") LongeurDto longeurDto, BindingResult newLongeurErrors,
      @PathVariable("voieID") String voieID) {
    model.addAttribute("VoieParent", voieMetier.consulterUneVoie(Long.valueOf(voieID)));
    longeurDto.setVoie(voieID);
    if (newLongeurErrors.hasErrors()) {
      return "views/creationLongeur";
    }
    // Mapping DTO form into JPA Entity
    longeurMetier.ajouterUneLongeur(longeurMapper.toLongeur(longeurDto));
    return "redirect:/viewVoie/" + voieID;
  }
}
