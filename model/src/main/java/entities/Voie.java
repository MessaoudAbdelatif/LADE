package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "voie")
public class Voie implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "Nom")
  private String nom;

  @ManyToOne
  @JoinColumn(name = "Secteur_id")
  private Secteur secteur;

  @Column(name = "Descreption")
  private String descreption;

  @Column(name = "Cotation")
  private String cotation;

  @OneToMany(mappedBy = "voie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Longeur> longeurs;

  public Voie() {
  }

  public Voie(String nom, Secteur secteur, String descreption, String cotation,
      List<Longeur> longeurs) {
    this.nom = nom;
    this.secteur = secteur;
    this.descreption = descreption;
    this.cotation = cotation;
    this.longeurs = longeurs;
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

  public List<Longeur> getLongeurs() {
    return longeurs;
  }

  public void setLongeurs(List<Longeur> longeurs) {
    this.longeurs = longeurs;
  }
}
