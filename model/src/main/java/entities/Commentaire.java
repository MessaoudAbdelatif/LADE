package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Commentaire")
public class Commentaire implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name ="Nom_Emmetteur")
  private UtilisateurConnecte utilisateurConnecte;

  @ManyToOne
  @JoinColumn(name = "Nom_Site_Escalade")
  private SiteEscalade siteEscalade;

  @Column(name = "Titre")
  private String titre;

  @Lob
  @Column(name = "Message")
  private String message;

  @Column(name = "Date_Edition")
  private Date dateEdition;

  public Commentaire() {
  }

  public Commentaire( UtilisateurConnecte utilisateurConnecte, SiteEscalade siteEscalade, String titre,
      String message, Date dateEdition) {

    this.utilisateurConnecte = utilisateurConnecte;
    this.siteEscalade = siteEscalade;
    this.titre = titre;
    this.message = message;
    this.dateEdition = dateEdition;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UtilisateurConnecte getUserName() {
    return utilisateurConnecte;
  }

  public void setUserName(UtilisateurConnecte utilisateurConnecte) {
    this.utilisateurConnecte = utilisateurConnecte;
  }

  public SiteEscalade getNomSiteEscalade() {
    return siteEscalade;
  }

  public void setNomSiteEscalade(SiteEscalade siteEscalade) {
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

  public Date getDateEdition() {
    return dateEdition;
  }

  public void setDateEdition(Date dateEdition) {
    this.dateEdition = dateEdition;
  }
}


