package com.lade.app.dto.impl;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentaireDto {

  protected Long id;
  protected String utilisateurConnecte;
  protected Long siteEscalade;
  protected String titre;
  @NotNull
  protected String message;
  protected Date dateCreation;
}
