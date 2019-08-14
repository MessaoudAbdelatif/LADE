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
  public String registerFormulaire(Model model) {
    model.addAttribute("utilisateurConnecte", new UtilisateurConnecte());
    model.addAttribute("civilite", Civilite.values());
    return "views/registration";
  }

  @PostMapping("/registration")
  public String registration(Model model, @Valid UtilisateurConnecte utilisateurConnecte,
      BindingResult bindingResult) {
    model.addAttribute("civilite", Civilite.values());
    if (bindingResult.hasErrors()) {
      return "views/registration";
    }
    utilisateurConnecteDao.save(utilisateurConnecte);
    return "views/registrationConfirme";
  }
}