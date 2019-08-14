package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class UtilisateurConnecte implements Serializable {

  @Id
  @Size(min = 5, max = 60)
  private String userName;

  private String civilite;

  @NotEmpty
  private String nom;

  @NotEmpty
  private String prenom;

  private String presentationPersonel;

  @Email
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

  public UtilisateurConnecte(
      String userName, String civilite, String nom, String prenom,
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

  public String getCivilite() {
    return civilite;
  }

  public void setCivilite(String civilite) {
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

  public Collection<DemandeLocation> getDemandeLocations() {
    return demandeLocations;
  }

  public void setDemandeLocations(Collection<DemandeLocation> demandeLocations) {
    this.demandeLocations = demandeLocations;
  }

  public Collection<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(Collection<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }
}
