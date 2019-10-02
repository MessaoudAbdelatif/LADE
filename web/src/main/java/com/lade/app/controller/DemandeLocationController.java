package com.lade.app.controller;

import com.lade.app.dto.contract.DemandeLocationMapper;
import com.lade.app.dto.contract.ToposMapper;
import com.lade.app.dto.impl.DemandeLocationDto;
import com.lade.app.dto.impl.ToposDto;
import entities.DemandeLocation;
import entities.Topos;
import entities.UtilisateurConnecte;
import javax.validation.Valid;
import metier.contract.DemandeLocationMetier;
import metier.contract.ToposMetier;
import metier.contract.UtilisateurConnecteMetier;
import metier.exception.ToposIntrouvableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class DemandeLocationController {

  private final DemandeLocationMapper demandeLocationMapper;
  private final DemandeLocationMetier demandeLocationMetier;
  private final ToposMetier toposMetier;
  private final ToposMapper toposMapper;
  private final UtilisateurConnecteMetier utilisateurConnecteMetier;

  public DemandeLocationController(
      DemandeLocationMapper demandeLocationMapper,
      DemandeLocationMetier demandeLocationMetier, ToposMetier toposMetier,
      ToposMapper toposMapper, UtilisateurConnecteMetier utilisateurConnecteMetier) {
    this.demandeLocationMapper = demandeLocationMapper;
    this.demandeLocationMetier = demandeLocationMetier;
    this.toposMetier = toposMetier;

    this.toposMapper = toposMapper;
    this.utilisateurConnecteMetier = utilisateurConnecteMetier;
  }

  /*//--------------------- Création d'Une Demande de Location -------------------------*/


  @GetMapping("/creationDemandeLocation/{topos_id}")
  public String creationDemandeLocation(Model model, @PathVariable("topos_id") Long toposId)
      throws ToposIntrouvableException {
    model.addAttribute("newDemandeLocation", new DemandeLocationDto());
    Topos toposSelected = toposMetier.consulterUnTopos(toposId);
    ToposDto toposDtoSelected = toposMapper.toToposDto(toposSelected);
    model.addAttribute("toposSelected", toposDtoSelected);
    return "views/creationDemandeLocation";
  }


  @PostMapping("/saveDemandeLocation/{topos_id}")
  public String saveCreationSiteEscalade(Model model, @PathVariable("topos_id") Long id,
      @Valid DemandeLocationDto demandeLocationDto,
      BindingResult newDemandeLocationErrors) throws ToposIntrouvableException {
    Topos toposSelected = toposMetier.consulterUnTopos(id);
    ToposDto toposDtoSelected = toposMapper.toToposDto(toposSelected);
    model.addAttribute("toposSelected", toposDtoSelected);
    demandeLocationDto.setTopos(toposDtoSelected.getId());
    if (newDemandeLocationErrors.hasErrors()) {
      return "views/creationDemandeLocation";
    }
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    demandeLocationDto.setUtilisateurConnecte(currentPrincipalName);
    DemandeLocation demandeLocation1 = demandeLocationMapper.toDemandeLocation(demandeLocationDto);
    demandeLocationMetier.ajouterUneDemandeLocation(demandeLocation1);

    return "redirect:/user/viewDemandeLocation/" + demandeLocation1.getId();
  }
  /*//___________________________________________________________________________*/

  /*//--------------------- Consulter Une Demande de Location ---------------//*/

  @GetMapping("/viewDemandeLocation/{id}")
  public String afficherUneDemandeLocation(Model model, @PathVariable("id") Long id) {
    try {
      DemandeLocation demandeLocationSelected = demandeLocationMetier.findDemandeLocationById(id);
      DemandeLocationDto demandeLocationDtoSelected = demandeLocationMapper
          .toDemandeLocationDto(demandeLocationSelected);
      model.addAttribute("demandeLocationDtoSelected", demandeLocationDtoSelected);
      Topos unTopos = toposMetier.consulterUnTopos(demandeLocationDtoSelected.getTopos());
      ToposDto unToposDto = toposMapper.toToposDto(unTopos);
      model.addAttribute("unTopos", unToposDto);
      UtilisateurConnecte unUtilisateurConnecte = utilisateurConnecteMetier
          .consulterUtilisateurConnecte(unToposDto.getUtilisateurConnecte());
      model.addAttribute("unUtilisateurConnecte", unUtilisateurConnecte);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewDemandeLocation";
  }
  /*//___________________________________________________________________________//*/

  /*//--------------------- Accepter Une Demande de Location ---------------//*/

  @PostMapping("/accepterDemandeLocation/{id}")
  public String accepterDemandeLocation(@PathVariable(name = "id") Long id)
      throws ToposIntrouvableException {
    demandeLocationMetier.accepterUneDemandeLocation(id);
    return "redirect:/user/viewDemandeLocation/" + id;
  }
  /*//___________________________________________________________________________//*/

  /*//--------------------- Refuser Une Demande de Location ---------------//*/

  @PostMapping("/refuserDemandeLocation/{id}")
  public String refuserDemandeLocation(@PathVariable(name = "id") Long id)
      throws ToposIntrouvableException {
    demandeLocationMetier.refuserUneDemandeLocation(id);
    return "redirect:/user/viewDemandeLocation/" + id;
  }
  /*
  //___________________________________________________________________________//
  */
}

