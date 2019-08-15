package com.lade.app.controller;

import dao.UtilisateurConnecteDao;
import entities.Civilite;
import entities.UtilisateurConnecte;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  @Autowired
  private UtilisateurConnecteDao utilisateurConnecteDao;

  @GetMapping("/registration")
  public java.lang.String registerFormulaire(Model model) {
    model.addAttribute("utilisateurConnecte", new UtilisateurConnecte());
    model.addAttribute("civiliteChoix", Civilite.values());
    return "views/registration";
  }

  @PostMapping("/save")
  public java.lang.String registration(Model model, @Valid UtilisateurConnecte utilisateurConnecte,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "views/registration";
    }
    utilisateurConnecteDao.save(utilisateurConnecte);
    return "views/registrationConfirme";
  }
}