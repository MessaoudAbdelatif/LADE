package com.lade.app.dto;

import entities.Commentaire;
import entities.Secteur;
import java.util.List;
import lombok.Data;

@Data
public class SiteEscaladeDto {

  // __________Attributes____________
  protected Long id;
  protected String nom;
  protected Integer nbrSecteur;
  protected String lieu;
  protected String villeProximite;
  protected String typeRoche;
  protected Boolean tag;
  protected List<Secteur> secteurs;
  protected List<Commentaire> commentaires;
// _________________________________


}
