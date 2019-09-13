package com.lade.app.dto.impl;

import entities.DemandeLocation;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class ToposDto {


  // __________Attributes____________
protected Long id;
protected String nom;
protected String description;
protected Date dateDeParution;
protected String lieuDeParution;
protected String utilisateurConnecte;
protected String lien;
protected Boolean loue;
protected List<DemandeLocation> demandeLocations;

}
