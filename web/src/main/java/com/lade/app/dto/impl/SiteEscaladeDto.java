package com.lade.app.dto.impl;

import entities.Commentaire;
import entities.Secteur;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SiteEscaladeDto {

  // __________Attributes____________
  protected Long id;
  @NotEmpty
  protected String nom;
  protected Integer nbrSecteur;
  @NotEmpty
  protected String lieu;
  protected String villeProximite;
  protected String typeRoche;
  protected Boolean tag;
  protected List<Secteur> secteurs;
  protected List<Commentaire> commentaires;
  // _________________________________
}
