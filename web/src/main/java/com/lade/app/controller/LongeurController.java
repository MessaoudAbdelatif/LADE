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
  public String afficherUneLongeur(Model model,@PathVariable("id") Long id) {
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
  @GetMapping("/creationLongeur/{id}")
  public String creationLongeur(Model model,  @PathVariable("id")Long id) {
    model.addAttribute("newLongeur", new LongeurDto(Long.toString(id)));
    model.addAttribute("idVoie", id);
    model.addAttribute("VoieParent",voieMetier.consulterUneVoie(id));
    model.addAttribute("cotationList", Cotation.getCotations());
    return "views/creationLongeur";
  }

  @PostMapping("/ajouterLongeur")
  public String ajouterLongeur(Model model,
      @Valid @ModelAttribute("newLongeur") LongeurDto longeurDto, BindingResult newLongeurErrors,@ModelAttribute("idVoie") String id) {

    if (newLongeurErrors.hasErrors()) {
      return "views/creationLongeur";
    }

    Longeur newLongeur = longeurMapper.toLongeur(longeurDto);      // Mapping DTO form into JPA Entity
    longeurMetier.ajouterUneLongeur(newLongeur);

    return "redirect:/viewVoie";
  }
}
