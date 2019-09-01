package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Topos")
public class Topos implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty
  @Column(name = "Nom")
  private String nom;

  @Column(name = "Description")
  private String description;
  @Column(name = "Lieu_De_Parution")
  private String lieuDeParution;

  @Column(name = "Date_De_Parution")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateDeParution;

  @Column(name = "Proprietaire")
  private String proprietaire;

  @Column(name = "Disponible_En_Location")
  private Boolean disponibleEnLocation;

  @Column(name = "Lien")
  private String lien;

  @Column(name = "Loue")
  private Boolean loue;

  @OneToMany(mappedBy = "nomTopos", fetch = FetchType.LAZY)
  private Set<DemandeLocation> demandeLocations  = new HashSet<>();

  public Topos() {
  }

  public Topos(@NotEmpty String nom, String description, String lieuDeParution,
      Date dateDeParution, String proprietaire, Boolean disponibleEnLocation) {
    this.nom = nom;
    this.description = description;
    this.lieuDeParution = lieuDeParution;
    this.dateDeParution = dateDeParution;
    this.proprietaire = proprietaire;
    this.disponibleEnLocation = disponibleEnLocation;
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

  public Set<DemandeLocation> getDemandeLocations() {
    return demandeLocations;
  }

  public void setDemandeLocations(Set<DemandeLocation> demandeLocations) {
    this.demandeLocations = demandeLocations;
  }
}
