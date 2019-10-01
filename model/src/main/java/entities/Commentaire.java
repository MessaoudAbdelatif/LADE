package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Commentaire")
public class Commentaire implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "Nom_Emetteur")
  private UtilisateurConnecte utilisateurConnecte;

  @ManyToOne
  @JoinColumn(name = "Nom_Site_Escalade")
  private SiteEscalade siteEscalade;

  @Column(name = "Titre")
  private String titre;

  @Column(name = "Message")
  private String message;

  @Column(name = "Date_Edition")
  private Date dateCreation;

  public Commentaire() {
  }

  /**
   *  Constructeur avec quelques attribues.
   * @param utilisateurConnecte la personne qui dépose le commentaire.
   * @param siteEscalade le site d'escalde conçerner par le commentaire.
   * @param titre titre du message.
   * @param message corps du message.
   * @param dateCreation la date de création du message.
   */
  public Commentaire(UtilisateurConnecte utilisateurConnecte, SiteEscalade siteEscalade,
      String titre, String message, Date dateCreation) {
    this.utilisateurConnecte = utilisateurConnecte;
    this.siteEscalade = siteEscalade;
    this.titre = titre;
    this.message = message;
    this.dateCreation = dateCreation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UtilisateurConnecte getUtilisateurConnecte() {
    return utilisateurConnecte;
  }

  public void setUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
    this.utilisateurConnecte = utilisateurConnecte;
  }

  public SiteEscalade getSiteEscalade() {
    return siteEscalade;
  }

  public void setSiteEscalade(SiteEscalade siteEscalade) {
    this.siteEscalade = siteEscalade;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }
}


