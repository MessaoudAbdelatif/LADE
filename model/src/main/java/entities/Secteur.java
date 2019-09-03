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
@Table(name = "Secteur")
public class Secteur implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "Nom")
  private String nom;

  @ManyToOne
  @JoinColumn(name = "siteEscalade_id")
  private SiteEscalade siteEscalade;

  @Column(name = "Description")
  private String description;

  @OneToMany(mappedBy = "secteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Voie> voies;

  public Secteur() {
  }

  public Secteur(@NotEmpty String nom, SiteEscalade siteEscalade, String description,
      List<Voie> voies) {
    this.nom = nom;
    this.siteEscalade = siteEscalade;
    this.description = description;
    this.voies = voies;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public SiteEscalade getSiteEscalade() {
    return siteEscalade;
  }

  public void setSiteEscalade(SiteEscalade siteEscalade) {
    this.siteEscalade = siteEscalade;

  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Voie> getVoies() {
    return voies;
  }

  public void setVoies(List<Voie> voies) {
    this.voies = voies;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  // Methode afin de liée ce Secteur avec une Voie lors de création Secteur
  // M'évite la creation de DTO pour le moment.
  public Secteur addVoie(Voie voie) {
    voie.setSecteur(this);
    this.voies.add(voie);
    return this;
  }
}
