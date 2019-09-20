package com.lade.app.dto.impl;

import com.lade.app.validation.FieldMatch;
import entities.Civilite;
import entities.Commentaire;
import entities.DemandeLocation;
import entities.Topos;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;


@FieldMatch(first = "confirmationMdp", second = "motDePasse",message = "Mot de passe incorrect !!")
@Data
public class UtilisateurConnecteDto {
  @Id
  @NotEmpty
  @Size(min = 5, max = 60)
  protected String userName;
  protected Civilite civilite;
  @NotEmpty
  protected String nom;
  @NotEmpty
  protected String prenom;
  protected String presentationPersonel;
  @NotEmpty
  @Email
  protected String email;
  protected Boolean etatCompte;
  @NotEmpty
  protected String motDePasse;
  protected String confirmationMdp;
  protected LocalDateTime dateCreation;
  protected List<DemandeLocation> demandeLocations;
  protected List<Commentaire> commentaires;
  protected List<Topos> topos;

}
