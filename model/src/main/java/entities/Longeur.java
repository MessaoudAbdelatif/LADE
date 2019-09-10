package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Longeur")
public class Longeur implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "Nom")
  private String nom;

  @ManyToOne
  @JoinColumn(name = "Voie_id")
  private Voie voie;

  @Column(name = "Cotation")
  private String cotation;


  public Longeur() {
  }

  public Longeur(String nom, Voie voie, String cotation) {
    this.nom = nom;
    this.voie = voie;
    this.cotation = cotation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
