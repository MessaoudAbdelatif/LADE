package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UtilisateurConnecte implements Serializable {

  @Id
  private String userName;
  @Enumerated(EnumType.STRING)
  private Civilite civilite;
  private String nom;
  private String prenom;
  private String presentationPersonel;
  private String email;
  private Boolean etatCompte;
  private String motDePasse;
  private Date dateCreation;
  @OneToMany(mappedBy = "userName", fetch = FetchType.LAZY)
  private Collection<DemandeLocation> demandeLocations;
  @OneToMany(mappedBy = "userName", fetch = FetchType.LAZY)
  private Collection<Commentaire> commentaires;


  public UtilisateurConnecte() {
  }

  public UtilisateurConnecte(String userName, Civilite civilite, String nom, String prenom,
      String presentationPersonel, String email) {
    this.userName = userName;
    this.civilite = civilite;
    this.nom = nom;
    this.prenom = prenom;
    this.presentationPersonel = presentationPersonel;
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Civilite getCivilite() {
    return civilite;
  }

  public void setCivilite(Civilite civilite) {
    this.civilite = civilite;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getPresentationPersonel() {
    return presentationPersonel;
  }

  public void setPresentationPersonel(String presentationPersonel) {
    this.presentationPersonel = presentationPersonel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getEtatCompte() {
    return etatCompte;
  }

  public void setEtatCompte(Boolean etatCompte) {
    this.etatCompte = etatCompte;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }
}
