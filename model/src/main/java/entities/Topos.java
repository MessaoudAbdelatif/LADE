package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topos implements Serializable {

  @Id
  private String nom;
  private String description;
  private String lieuDeParution;
  private Date dateDeParution;
  private String proprietaire;
  private Boolean disponibleEnLocation;
  private String lien;
  private Boolean loue;
  @OneToMany(mappedBy = "nomTopos", fetch = FetchType.LAZY)
  private Collection<DemandeLocation> demandeLocations;

  public Topos() {
  }

  public Topos(String nom, String description, String lieuDeParution, Date dateDeParution,
      String proprietaire, Boolean disponibleEnLocation, String lien, Boolean loue,
      Collection<DemandeLocation> demandeLocations) {
    this.nom = nom;
    this.description = description;
    this.lieuDeParution = lieuDeParution;
    this.dateDeParution = dateDeParution;
    this.proprietaire = proprietaire;
    this.disponibleEnLocation = disponibleEnLocation;
    this.lien = lien;
    this.loue = loue;
    this.demandeLocations = demandeLocations;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLieuDeParution() {
    return lieuDeParution;
  }

  public void setLieuDeParution(String lieuDeParution) {
    this.lieuDeParution = lieuDeParution;
  }

  public Date getDateDeParution() {
    return dateDeParution;
  }

  public void setDateDeParution(Date dateDeParution) {
    this.dateDeParution = dateDeParution;
  }

  public String getProprietaire() {
    return proprietaire;
  }

  public void setProprietaire(String proprietaire) {
    this.proprietaire = proprietaire;
  }

  public Boolean getDisponibleEnLocation() {
    return disponibleEnLocation;
  }

  public void setDisponibleEnLocation(Boolean disponibleEnLocation) {
    this.disponibleEnLocation = disponibleEnLocation;
  }

  public String getLien() {
    return lien;
  }

  public void setLien(String lien) {
    this.lien = lien;
  }

  public Boolean getLoue() {
    return loue;
  }

  public void setLoue(Boolean loue) {
    this.loue = loue;
  }

  public Collection<DemandeLocation> getDemandeLocations() {
    return demandeLocations;
  }

  public void setDemandeLocations(Collection<DemandeLocation> demandeLocations) {
    this.demandeLocations = demandeLocations;
  }
}
