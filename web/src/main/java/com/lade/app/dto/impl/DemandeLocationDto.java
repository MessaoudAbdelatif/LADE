package com.lade.app.dto.impl;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DemandeLocationDto {
  // __________Attributes____________
  protected Long id;
  @NotEmpty
  protected Date dateDebut;
  @NotEmpty
  protected Date dateFin;
  protected Long topos;
  protected String utilisateurConnecte;
  protected String message;
  protected Boolean proprioValidation;
}
