package com.lade.app.dto.impl;



import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
public class DemandeLocationDto {

  // __________Attributes____________
  protected Long id;
  @NotNull
  protected String dateDebut;
  @NotNull
  protected String dateFin;

  protected Long topos;
  protected String utilisateurConnecte;
  protected String message;
  protected Boolean proprioValidation;
}
