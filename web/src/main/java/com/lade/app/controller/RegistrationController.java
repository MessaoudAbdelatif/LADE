package com.lade.app.controller;

import com.lade.app.dto.contract.UtilisateurConnecteMapper;
import com.lade.app.dto.impl.UtilisateurConnecteDto;
import entities.Civilite;
import javax.validation.Valid;
import metier.contract.UtilisateurConnecteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {


  private UtilisateurConnecteMetier utilisateurConnecteMetier;
  private UtilisateurConnecteMapper utilisateurConnecteMapper;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  @Autowired
  public RegistrationController(UtilisateurConnecteMetier utilisateurConnecteMetier,
      UtilisateurConnecteMapper utilisateurConnecteMapper,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.utilisateurConnecteMetier = utilisateurConnecteMetier;
    this.utilisateurConnecteMapper = utilisateurConnecteMapper;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  /* @InitBinder -> Spring execute cette méthode quand RegistrationController est appelé
   *  Je l'utilise afin d'éviter que l'utilisateur insère un champ vide (d'espace)
   * stringTrimmerEditor me permet de supprimer le vide*/
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }


  @GetMapping("/registration")
  public String registerFormulaire(Model model) {
    model.addAttribute("utilisateurConnecte", new UtilisateurConnecteDto());
    model.addAttribute("civiliteChoix", Civilite.values());
    return "views/registration";
  }

  @PostMapping("/save")
  public String registration(Model model, @ModelAttribute("utilisateurConnecte")
  @Valid @NonNull UtilisateurConnecteDto utilisateurConnecteDto,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("civiliteChoix", Civilite.values());
      return "views/registration";
    }
    utilisateurConnecteDto.setMotDePasse(bCryptPasswordEncoder.encode(utilisateurConnecteDto.getMotDePasse()));
    utilisateurConnecteMetier.ajouterUtilisateurConnecte(
        utilisateurConnecteMapper.toUtilisateurConnecte(utilisateurConnecteDto));
    return "views/registrationConfirme";
  }
}