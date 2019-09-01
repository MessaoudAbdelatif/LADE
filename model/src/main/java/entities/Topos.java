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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @ManyToOne
  @JoinColumn(name = "Utilisateur_id")
  private UtilisateurConnecte utilisateurConnecte;

  @Column(name = "Disponible_En_Location")
  private Boolean disponibleEnLocation;

  @Column(name = "Lien")
  private String lien;

  @Column(name = "Loue")
  private Boolean loue;

  @OneToMany(mappedBy = "topos", fetch = FetchType.LAZY)
  private Set<DemandeLocation> demandeLocations  = new HashSet<>();

  public Topos() {
  }

  public Topos(@NotEmpty String nom, String description, String lieuDeParution,
      Date dateDeParution, UtilisateurConnecte utilisateurConnecte,
      Boolean disponibleEnLocation) {
    this.nom = nom;
    this.description = description;
    this.lieuDeParution = lieuDeParution;
    this.dateDeParution = dateDeParution;
    this.utilisateurConnecte = utilisateurConnecte;
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

  public UtilisateurConnecte getUtilisateurConnecte() {
    return utilisateurConnecte;
  }

  public void setUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
    this.utilisateurConnecte = utilisateurConnecte;
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
