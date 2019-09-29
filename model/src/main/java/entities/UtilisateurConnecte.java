package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Utilisateur_Connecte")
public class UtilisateurConnecte implements Serializable {

  @Id
  @NotEmpty
  @Size(min = 5, max = 60)
  private String username;

  @Enumerated(EnumType.STRING)
  private Civilite civilite;

  @NotEmpty
  @Column(name = "Nom")
  private String nom;

  @NotEmpty
  @Column(name = "Prenom")
  private String prenom;

  @Column(name = "Presentation_Personel")
  private String presentationPersonel;

  @NotEmpty
  @Email
  @Column(name = "Email")
  private String email;

  @Column(name = "Etat_Compte")
  private Boolean etatCompte;

  @NotEmpty
  @Column(name = "Mot_De_Pass")
  private String motDePasse;


  @Column(name = "Date_Creation")
  private LocalDateTime dateCreation;

  @OneToMany(mappedBy = "utilisateurConnecte", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<DemandeLocation> demandeLocations;

  @OneToMany(mappedBy = "utilisateurConnecte", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Commentaire> commentaires;

  @OneToMany(mappedBy = "utilisateurConnecte", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Topos> topos;

  @ManyToMany
  @JoinTable(
      name = "utilisateurConnecte_roles",
      joinColumns = {@JoinColumn(name = "username")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private List<Role> roles;


  public UtilisateurConnecte() {
  }

  public UtilisateurConnecte(
      @Size(min = 5, max = 60) String username, Civilite civilite,
      @NotEmpty String nom, @NotEmpty String prenom,
      @NotEmpty @Email String email, Boolean etatCompte, String motDePasse,
      LocalDateTime dateCreation) {
    this.username = username;
    this.civilite = civilite;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.etatCompte = etatCompte;
    this.motDePasse = motDePasse;
    this.dateCreation = dateCreation;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public LocalDateTime getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDateTime dateCreation) {
    this.dateCreation = dateCreation;
  }

  public List<DemandeLocation> getDemandeLocations() {
    return demandeLocations;
  }

  public void setDemandeLocations(List<DemandeLocation> demandeLocations) {
    this.demandeLocations = demandeLocations;
  }

  public List<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(List<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }

  public List<Topos> getTopos() {
    return topos;
  }

  public void setTopos(List<Topos> topos) {
    this.topos = topos;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}