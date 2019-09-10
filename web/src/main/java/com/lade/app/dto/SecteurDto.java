package com.lade.app.dto;

import entities.Voie;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data
//@NoArgsConstructor
public class SecteurDto {

  // __________Attributes____________
  protected Long id;
  @NotEmpty
  protected String nom;
  protected String siteEscalade;
  protected String description;
  protected List<Voie> voies;


  // __________Constructor____________
 /* public SecteurDto(String siteEscalade) {
    this.siteEscalade = siteEscalade;
  }*/
}

