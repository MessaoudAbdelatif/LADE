package com.lade.app.controller;

import entities.Civilite;
import entities.UtilisateurConnecte;
import javax.validation.Valid;
import metier.contract.UtilisateurConnecteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {


  private UtilisateurConnecteMetier utilisateurConnecteMetier;

  @Autowired
  public RegistrationController(
      UtilisateurConnecteMetier utilisateurConnecteMetier) {
    this.utilisateurConnecteMetier = utilisateurConnecteMetier;
  }

  @GetMapping("/registration")
  public String registerFormulaire(Model model) {
    model.addAttribute("utilisateurConnecte", new UtilisateurConnecte());
    model.addAttribute("civiliteChoix", Civilite.values());
    return "views/registration";
  }

  @PostMapping("/save")
  public String registration(Model model,
      @Valid @NonNull UtilisateurConnecte utilisateurConnecte,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("civiliteChoix", Civilite.values());
      return "views/registration";
    }
    utilisateurConnecteMetier.ajouterUtilisateurConnecte(utilisateurConnecte);
    return "views/registrationConfirme";
  }
}