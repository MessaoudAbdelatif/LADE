package com.lade.app.controller;

import com.lade.app.dto.contract.ToposMapper;
import com.lade.app.dto.impl.ToposDto;
import entities.Topos;
import java.util.List;
import javax.validation.Valid;
import metier.contract.ToposMetier;
import metier.exception.ToposIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ToposController {

  private ToposMetier toposMetier;
  private ToposMapper toposMapper;

  @Autowired
  public ToposController(ToposMetier toposMetier, ToposMapper toposMapper) {
    this.toposMetier = toposMetier;
    this.toposMapper = toposMapper;
  }

  //--------------------- Création d'Un Topos -------------------------

  @GetMapping("/creationTopos")
  public String creationTopos(Model model) {
    model.addAttribute("newTopos", new ToposDto());
    return "views/creationTopos";
  }

  @PostMapping("/saveCreationTopos")
  public String saveCreationTopos(Model model, @Valid @ModelAttribute("newTopos") ToposDto toposDto,
      BindingResult newToposErrors) {
    if (newToposErrors.hasErrors()) {
      return "views/creationTopos";
    }

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    toposDto.setUtilisateurConnecte(currentPrincipalName);

    toposDto.setDisponibleEnLocation(false);
    Topos topos1 = toposMapper.toTopos(toposDto);
    toposMetier.ajouterUnTopos(topos1);
    return "redirect:/user/viewTopos/" + topos1.getId();
  }

  //___________________________________________________________________________

  //--------------------- Consulter un topos en particulier ---------------

  @GetMapping("/viewTopos/{id}")
  public String afficherUnTopos(Model model, @PathVariable("id") Long id) {
    try {
      Topos toposSelected = toposMetier.consulterUnTopos(id);
      ToposDto toposDtoSelected = toposMapper.toToposDto(toposSelected);
      model.addAttribute("toposSelected", toposDtoSelected);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewTopos";
  }

  //___________________________________________________________________________

  /*//--------------------- Accepter Une Demande de Location ---------------//*/


  @PostMapping("/toposDisponibleLocation/{id}")
  public String toposDisponibleLocation(@PathVariable(name = "id") Long id)
      throws ToposIntrouvableException {
    toposMetier.toposDisponibleLocation(id);
    return "redirect:/user/viewTopos/" + id;
  }
  /*//___________________________________________________________________________//*/

  /*//--------------------- Refuser Une Demande de Location ---------------//*/

  @PostMapping("/toposIndisponibleLocation/{id}")
  public String toposIndisponibleLocation(@PathVariable(name = "id") Long id)
      throws ToposIntrouvableException {
    toposMetier.toposIndisponibleLocation(id);
    return "redirect:/user/viewTopos/" + id;
  }
  /*
  //___________________________________________________________________________//
  */

  /*//--------------------- Consulter All Topos ---------------//*/
  @GetMapping("/topos")
  public String consulterAllTopos(Model model) {
    List<Topos> topos = toposMetier.consulterAllTopos();
    model.addAttribute("toposList", topos);
    return "views/topos";
  }

  /*//---------------------------------------------------------//*/


}
