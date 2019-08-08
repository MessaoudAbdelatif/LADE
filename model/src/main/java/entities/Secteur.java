package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Secteur implements Serializable {
  @Id
  private String nom;
  private String nomSiteEscalade;
  private String description;
  @OneToMany(mappedBy = "nomSecteur", fetch = FetchType.LAZY)
  private Collection<Voie> voies;

  public Secteur() {
  }

  public Secteur(String nom, String nomSiteEscalade, String description,
      Collection<Voie> voies) {
    this.nom = nom;
    this.nomSiteEscalade = nomSiteEscalade;
    this.description = description;
    this.voies = voies;
  }
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getNomSiteEscalade() {
    return nomSiteEscalade;
  }

  public void setNomSiteEscalade(String nomSiteEscalade) {
    this.nomSiteEscalade = nomSiteEscalade;
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
