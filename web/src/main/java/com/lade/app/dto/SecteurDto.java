package com.lade.app.dto;

import entities.SiteEscalade;
import entities.Voie;
import java.util.Set;

public class SecteurDto {
  // __________Attributes____________
  protected String nom;
  private SiteEscalade siteEscalade;
  private String description;
  private Set<Voie> voies;

  //_____Getter&Setter_________________

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public SiteEscalade getSiteEscalade() {
    return siteEscalade;
  }

  public void setSiteEscalade(SiteEscalade siteEscalade) {
    this.siteEscalade = siteEscalade;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Voie> getVoies() {
    return voies;
  }

  public void setVoies(Set<Voie> voies) {
    this.voies = voies;
  }
}
