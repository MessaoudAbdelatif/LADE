package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Longeur implements Serializable {
  @Id
  private String nom;
  @ManyToOne
  @JoinColumn(name = "NOM_VOIE")
  private Voie voie;
  private String cotation;





  public Longeur() {
  }

  public Longeur(String nom, Voie voie, String cotation) {
    this.nom = nom;
    this.voie = voie;
    this.cotation = cotation;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Voie getVoie() {
    return voie;
  }

  public void setVoie(Voie voie) {
    this.voie = voie;
  }

  public String getCotation() {
    return cotation;
  }

  public void setCotation(String cotation) {
    this.cotation = cotation;
  }
}
