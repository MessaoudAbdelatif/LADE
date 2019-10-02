package com.lade.app.controller;

import com.lade.app.dto.contract.CommentaireMapper;
import com.lade.app.dto.impl.CommentaireDto;
import entities.Commentaire;
import javax.validation.Valid;
import metier.contract.CommentaireMetier;
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
public class CommentaireController {

  private final CommentaireMetier commentaireMetier;
  private final CommentaireMapper commentaireMapper;


  public CommentaireController(CommentaireMetier commentaireMetier,
      CommentaireMapper commentaireMapper) {
    this.commentaireMetier = commentaireMetier;
    this.commentaireMapper = commentaireMapper;

  }
  //--------------------- Création d'Un Commentaire -------------------------

  @GetMapping("/creationCommentaire/{siteEscaladeId}")
  public String creationCommentaire(Model model,
      @PathVariable(name = "siteEscaladeId") Long siteEscaladeId) {
    model.addAttribute("siteEscaladeId", siteEscaladeId);
    model.addAttribute("newCommentaire", new CommentaireDto());
    return "views/creationCommentaire";
  }

  @PostMapping("/saveCreationCommentaire/{siteEscaladeId}")
  public String saveCreationCommentaire(Model model,
      @Valid @ModelAttribute("newCommentaire") CommentaireDto commentaireDto,
      BindingResult newCommentaireErrors,
      @PathVariable(name = "siteEscaladeId") Long siteEscaladeId) {
    model.addAttribute("siteEscaladeId", siteEscaladeId);
    if (newCommentaireErrors.hasErrors()) {
      return "views/creationCommentaire";
    }
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    commentaireDto.setUtilisateurConnecte(currentPrincipalName);
    commentaireDto.setSiteEscalade(siteEscaladeId);
    Commentaire unCommentaire = commentaireMapper.toCommentaire(commentaireDto);
    commentaireMetier.ajouterUnCommentaire(unCommentaire);
    return "redirect:/viewSiteEscalade?id=" + siteEscaladeId;
  }

  //___________________________________________________________________________

  /*//--------------------- Mise à jour d'un commentaire ---------------//*/

  @GetMapping("/updateUnCommentaire/{id}")
  public String updateUnCommentaire(Model model, @PathVariable("id") Long id) {
    Commentaire commentaireSelected = commentaireMetier.findCommentaireById(id);
    CommentaireDto commentaireDtoSelected = commentaireMapper
        .toCommentaireDto(commentaireSelected);
    model.addAttribute("commentaireDtoSelected", commentaireDtoSelected);
    model.addAttribute("idSiteEscalade", commentaireSelected.getSiteEscalade().getId());
    return "views/modifierCommentaire";
  }

  @PostMapping("/saveUpdateUnCommentaire/{id}")
  public String saveUpdateUnCommentaire(Model model, @PathVariable(name = "id") Long id,
      @Valid @ModelAttribute("commentaireDtoSelected") CommentaireDto commentaireDto,
      BindingResult updateCommentaireErrors) {
    if (updateCommentaireErrors.hasErrors()) {
      return " views/modifierCommentaire";
    }

    Commentaire unCommentaire = commentaireMapper.toCommentaire(commentaireDto);
    commentaireMetier.updateUnCommentaire(unCommentaire);
    return "redirect:/viewSiteEscalade?id=" + unCommentaire.getSiteEscalade().getId();
  }
  /*//___________________________________________________________________________//*/

  /*//--------------------- Suppression d'un commentaire ---------------//*/
  @PostMapping("/deleteUnCommentaire/{id}")
  public String deleteUnCommentaire(Model model, @PathVariable(name = "id") Long id) {
    Commentaire unCommentaire = commentaireMetier.findCommentaireById(id);
    commentaireMetier.deleteCommentaire(id);
    return "redirect:/viewSiteEscalade?id=" + unCommentaire.getSiteEscalade().getId();
  }

  /*
  //___________________________________________________________________________//
  */
  /*//--------------------- Consulter d'un commentaire ---------------//*/
  @GetMapping("/consulterUnCommentaire/{id}")
  public String consulterUnCommentaire(Model model, @PathVariable(name = "id") Long id) {
    Commentaire commentaireSelected = commentaireMetier.findCommentaireById(id);
    CommentaireDto commentaireDtoSelected = commentaireMapper
        .toCommentaireDto(commentaireSelected);
    model.addAttribute("commentaireDtoSelected", commentaireDtoSelected);
    return "views/viewCommentaire";
  }
}
