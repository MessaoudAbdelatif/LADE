package com.lade.app.dto;

import entities.Voie;
import java.util.List;
import lombok.Data;


@Data
public class SecteurDto {
  // __________Attributes____________
  protected Long id;
  protected String nom;
  protected String siteEscalade;
  protected String description;
  protected List<Voie> voies;

  public SecteurDto(String siteEscalade) {
    this.siteEscalade = siteEscalade;
  }
}

