package com.lade.app.controller;

import com.lade.app.dto.contract.DemandeLocationMapper;
import com.lade.app.dto.impl.DemandeLocationDto;
import entities.DemandeLocation;
import javax.validation.Valid;
import metier.contract.DemandeLocationMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class DemandeLocationController {

  private final DemandeLocationMapper demandeLocationMapper;
  private final DemandeLocationMetier demandeLocationMetier;


  public DemandeLocationController(
      DemandeLocationMapper demandeLocationMapper,
      DemandeLocationMetier demandeLocationMetier) {
    this.demandeLocationMapper = demandeLocationMapper;
    this.demandeLocationMetier = demandeLocationMetier;
  }


//--------------------- Création d'Une Demande de Location -------------------------


  @GetMapping("/creationDemandeLocation")
  public String creationDemandeLocation(Model model) {
    model.addAttribute("newDemandeLocation", new DemandeLocationDto());
    return "views/creationDemandeLocation";
  }


  @PostMapping("/saveDemandeLocation")
  public String saveCreationSiteEscalade(Model model,
      @Valid @ModelAttribute("newDemandeLocation") DemandeLocationDto demandeLocationDto,
      BindingResult newDemandeLocationErrors) {
    if (newDemandeLocationErrors.hasErrors()) {
      return "views/creationDemandeLocation";
    }
    DemandeLocation demandeLocation1 = demandeLocationMapper.toDemandeLocation(demandeLocationDto);
    demandeLocationMetier.ajouterUneDemandeLocation(demandeLocation1);

    return "redirect:/viewDemandeLocation?id=" + demandeLocation1.getId();
  }
  //___________________________________________________________________________
}

