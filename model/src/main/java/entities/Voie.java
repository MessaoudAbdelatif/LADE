package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voie implements Serializable {

  @Id
  private String nom;
  @ManyToOne
  @JoinColumn(name = "NOM_SECTEUR")
  private Secteur secteur;
  private String descreption;
  private String cotation;
  @OneToMany(mappedBy = "voie", fetch = FetchType.LAZY)
  private Collection<Longeur> longeurs;

  public Voie() {
  }

  public Voie(String nom, Secteur secteur, String descreption, String cotation,
      Collection<Longeur> longeurs) {
    this.nom = nom;
    this.secteur = secteur;
    this.descreption = descreption;
    this.cotation = cotation;
    this.longeurs = longeurs;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Secteur getSecteur() {
    return secteur;
  }

  public void setSecteur(Secteur secteur) {
    this.secteur = secteur;
  }

  public String getDescreption() {
    return descreption;
  }

  public void setDescreption(String descreption) {
    this.descreption = descreption;
  }

  public String getCotation() {
    return cotation;
  }

  public void setCotation(String cotation) {
    this.cotation = cotation;
  }

  public Collection<Longeur> getLongeurs() {
    return longeurs;
  }

  public void setLongeurs(Collection<Longeur> longeurs) {
    this.longeurs = longeurs;
  }
}
