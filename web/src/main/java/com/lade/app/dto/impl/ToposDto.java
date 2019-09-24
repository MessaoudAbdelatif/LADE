package com.lade.app.dto.impl;

import entities.DemandeLocation;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;

@Data
public class ToposDto {


  // __________Attributes____________
  protected Long id;
  @NotEmpty
  protected String nom;
  protected String description;
  @CreationTimestamp
  protected Date dateDeParution;
  protected String lieuDeParution;

  protected String utilisateurConnecte;
  private Boolean disponibleEnLocation;
  @URL
  protected String lien;
  protected List<DemandeLocation> demandeLocations;

}
