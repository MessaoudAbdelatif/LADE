package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Secteur implements Serializable {
  @Id
  @NotEmpty
  private String nom;

  @ManyToOne
  @JoinColumn(name = "NOM_SITE")
  private SiteEscalade siteEscalade;
  private String description;
  @OneToMany(mappedBy = "secteur", fetch = FetchType.LAZY)
  private Collection<Voie> voies;

  public Secteur() {
  }

  public Secteur(String nom, SiteEscalade siteEscalade, String description,
      Collection<Voie> voies) {
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

  public Collection<Voie> getVoies() {
    return voies;
  }

  public void setVoies(Collection<Voie> voies) {
    this.voies = voies;
  }
}
