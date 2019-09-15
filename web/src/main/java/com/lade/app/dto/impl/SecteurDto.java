package com.lade.app.dto.impl;

import entities.Voie;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;


@Data
public class SecteurDto {

  // __________Attributes____________
  protected Long id;
  @NotEmpty
  @Size(min = 3, max = 50)
  protected String nom;
  protected String siteEscalade;
  protected String description;
  protected List<Voie> voies;

}

