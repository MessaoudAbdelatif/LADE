package com.lade.app.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SiteEscalade implements Serializable {

  @Id
  private String nom;
  private String secteur;
  private int nbrSecteur;
  private String voies;
  private String longeurs;
  private String lieu;
  private String cotation;
  private boolean tag;


  public SiteEscalade() {
    this.nom = nom;
  }

  public SiteEscalade(String nom, String secteur, int nbrSecteur, String voies,
      String longeurs, String lieu, String cotation, boolean tag) {
    this.nom = nom;
    this.secteur = secteur;
    this.nbrSecteur = nbrSecteur;
    this.voies = voies;
    this.longeurs = longeurs;
    this.lieu = lieu;
    this.cotation = cotation;
    this.tag = tag;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getSecteur() {
    return secteur;
  }

  public void setSecteur(String secteur) {
    this.secteur = secteur;
  }

  public int getNbrSecteur() {
    return nbrSecteur;
  }

  public void setNbrSecteur(int nbrSecteur) {
    this.nbrSecteur = nbrSecteur;
  }

  public String getVoies() {
    return voies;
  }

  public void setVoies(String voies) {
    this.voies = voies;
  }

  public String getLongeurs() {
    return longeurs;
  }

  public void setLongeurs(String longeurs) {
    this.longeurs = longeurs;
  }

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

  public String getCotation() {
    return cotation;
  }

  public void setCotation(String cotation) {
    this.cotation = cotation;
  }

  public boolean isTag() {
    return tag;
  }

  public void setTag(boolean tag) {
    this.tag = tag;
  }
}
