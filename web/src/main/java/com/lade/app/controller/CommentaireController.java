package com.lade.app.controller;

import com.lade.app.dto.contract.CommentaireMapper;
import com.lade.app.dto.impl.CommentaireDto;
import entities.Commentaire;
import javax.validation.Valid;
import metier.contract.CommentaireMetier;
import metier.contract.SiteEscaladeMetier;
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
  private final SiteEscaladeMetier siteEscaladeMetier;


  public CommentaireController(CommentaireMetier commentaireMetier,
      CommentaireMapper commentaireMapper, SiteEscaladeMetier siteEscaladeMetier) {
    this.commentaireMetier = commentaireMetier;
    this.commentaireMapper = commentaireMapper;
    this.siteEscaladeMetier = siteEscaladeMetier;
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
    return "redirect:/viewSiteEscalade?id="+ siteEscaladeId;
  }

  //___________________________________________________________________________

}
