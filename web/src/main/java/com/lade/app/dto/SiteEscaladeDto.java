package com.lade.app.dto;

import entities.Commentaire;
import entities.Secteur;
import java.util.Set;

public class SiteEscaladeDto {
// __________Attributes____________
  protected String nom;
  protected int nbrSecteur;
  protected String lieu;
  protected String villeProximite;
  protected String typeRoche;
  protected boolean tag;
  protected Set<Secteur> secteurs;
  protected Set<Commentaire> commentaires;
// _________________________________


  //_____Getter&Setter_________________

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getNbrSecteur() {
    return nbrSecteur;
  }

  public void setNbrSecteur(int nbrSecteur) {
    this.nbrSecteur = nbrSecteur;
  }

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

  public String getVilleProximite() {
    return villeProximite;
  }

  public void setVilleProximite(String villeProximite) {
    this.villeProximite = villeProximite;
  }

  public String getTypeRoche() {
    return typeRoche;
  }

  public void setTypeRoche(String typeRoche) {
    this.typeRoche = typeRoche;
  }

  public boolean isTag() {
    return tag;
  }

  public void setTag(boolean tag) {
    this.tag = tag;
  }

  public Set<Secteur> getSecteurs() {
    return secteurs;
  }

  public void setSecteurs(Set<Secteur> secteurs) {
    this.secteurs = secteurs;
  }

  public Set<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(Set<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }
}
