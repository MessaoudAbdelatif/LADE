package com.lade.app.controller;

import com.lade.app.dto.contract.UtilisateurConnecteMapper;
import com.lade.app.dto.impl.UtilisateurConnecteDto;
import entities.UtilisateurConnecte;
import metier.contract.UtilisateurConnecteMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class EspacePersoController {

  private final UtilisateurConnecteMapper utilisateurConnecteMapper;
  private final UtilisateurConnecteMetier utilisateurConnecteMetier;

  public EspacePersoController(UtilisateurConnecteMapper utilisateurConnecteMapper,
      UtilisateurConnecteMetier utilisateurConnecteMetier) {
    this.utilisateurConnecteMapper = utilisateurConnecteMapper;
    this.utilisateurConnecteMetier = utilisateurConnecteMetier;
  }

  @GetMapping("/espacePerso/{username}")
  public String afficherDonneesUtilisateur(Model model, @PathVariable String username) {
    try {
      UtilisateurConnecte utilisateurConnecteSelected = utilisateurConnecteMetier
          .consulterUtilisateurConnecte(username);
      UtilisateurConnecteDto utilisateurConnecteDtoSelected = utilisateurConnecteMapper
          .toUtilisateurConnecteDto(utilisateurConnecteSelected);
      model.addAttribute("utilisateur", utilisateurConnecteDtoSelected);

    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/espacePerso";
  }
}
