package com.lade.app.controller;


import com.lade.app.dto.SiteEscaladeDto;
import com.lade.app.dto.SiteEscaladeMapper;
import entities.SiteEscalade;
import javax.validation.Valid;
import metier.SiteEscaladeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteEscaladeController {

  private static final String VIEWS_CREATION_SITE_ESCALADE ="views/creationSiteEscalade";
  private SiteEscaladeMetier siteEscaladeMetier;
  private SiteEscaladeMapper siteEscaladeMapper;

  @Autowired   // Annotation facultative (Injection via Constructeur)
  public SiteEscaladeController(SiteEscaladeMetier siteEscaladeMetier,
      SiteEscaladeMapper siteEscaladeMapper) {
    this.siteEscaladeMetier = siteEscaladeMetier;
    this.siteEscaladeMapper = siteEscaladeMapper;
  }

//--------------------- Consulte & Affiche "NOS SITES ESCALADES" ---------------
  @GetMapping("/siteEscalade")
  public String siteEscalade(Model model,
      @RequestParam(name = "numPages", defaultValue = "0") int numPages,
      @RequestParam(name = "nomSiteEscaladeInsere", defaultValue = "") String sei,
      @RequestParam(name = "typeRecherche", defaultValue = "NOM") String typeRecherche) {
    try {
      Page<SiteEscalade> pagesiteEscalade = siteEscaladeMetier
          .rechercherDesSitesEscalades(numPages, 5, sei, typeRecherche);
      model.addAttribute("siteEscalade", pagesiteEscalade.getContent());
      model.addAttribute("pages", new int[pagesiteEscalade.getTotalPages()]);
      model.addAttribute("nbrPagesTotal", new int[pagesiteEscalade.getTotalPages()].length);
      model.addAttribute("currentPage", numPages);
      model.addAttribute("currentTypeRecherche", typeRecherche);
      model.addAttribute("sei", sei);
    } catch (Exception e) {
      model.addAttribute("exceptionAucunSiteEscaladeTrouve", e);
    }

    return "views/siteEscalade";
  }
  //___________________________________________________________________________

//--------------------- Consulter un site d'escalade en particulier ---------------

  @GetMapping("/viewSiteEscalade")
  public String afficherUnSiteEscalade(Model model, Long id) {
    try {
      SiteEscalade siteEscaladeSelected = siteEscaladeMetier.consulterUnSiteEscalade(id);
      model.addAttribute("siteEscaladeSelected", siteEscaladeSelected);
    } catch (Exception e) {
      model.addAttribute("exception", e);
    }
    return "views/viewSiteEscalade";
  }

  //___________________________________________________________________________


//--------------------- Editer Un Site d'Escalade existant--------------------


  @GetMapping("/edit/{id}")
  public String modifierSiteEscalade(Model model, @PathVariable("id") Long id) {
    SiteEscalade siteEscaladeSelected = siteEscaladeMetier.consulterUnSiteEscalade(id);
    model.addAttribute("updateSiteEscalade", siteEscaladeSelected);
    model.addAttribute("idSiteEscaladePresent", siteEscaladeSelected.getId());
    return "views/modifierSiteEscalade";
  }



  @PostMapping("/saveModificationSiteEscalade/{id}")
  public String saveModificationSiteEscalade(Model model,
      @Valid @ModelAttribute("newSiteEscalade") SiteEscaladeDto siteEscaladeDto,
      BindingResult newSiteEscaladeErrors, @PathVariable("id") Long id) {
    if (newSiteEscaladeErrors.hasErrors()) {
      return VIEWS_CREATION_SITE_ESCALADE;
    }
    SiteEscalade siteEscalade1 = siteEscaladeMapper.toSiteEscalade(siteEscaladeDto);
    siteEscalade1.setId(id);
    siteEscaladeMetier.ajouterUnSiteEscalade(siteEscalade1);

    return "redirect:/viewSiteEscalade?id=" + siteEscalade1.getId();
  }

  //___________________________________________________________________________

//--------------------- Création d'Un Site d'Escalade -------------------------


  @GetMapping("/creationSiteEscalade")
  public String creationSiteEscalade(Model model) {
    model.addAttribute("newSiteEscalade", new SiteEscaladeDto());
    return VIEWS_CREATION_SITE_ESCALADE;
  }


  @PostMapping("/saveCreationSiteEscalade")
  public String saveCreationSiteEscalade(Model model,
      @Valid @ModelAttribute("newSiteEscalade") SiteEscaladeDto siteEscaladeDto,
      BindingResult newSiteEscaladeErrors) {
    if (newSiteEscaladeErrors.hasErrors()) {
      return VIEWS_CREATION_SITE_ESCALADE;
    }
    SiteEscalade siteEscalade1 = siteEscaladeMapper.toSiteEscalade(siteEscaladeDto);
    siteEscaladeMetier.ajouterUnSiteEscalade(siteEscalade1);

    return "redirect:/viewSiteEscalade?id=" + siteEscalade1.getId();
  }
  //___________________________________________________________________________
}