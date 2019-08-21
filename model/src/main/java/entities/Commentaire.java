package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Commentaire implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name ="NOM_EMETTEUR")
  private UtilisateurConnecte utilisateurConnecte;
  @ManyToOne
  @JoinColumn(name = "NOM_SITE_ESCALADE")
  private SiteEscalade siteEscalade;
  private String titre;
  private String message;
  private Date dateEdition;

  public Commentaire() {
  }

  public Commentaire(Long id, UtilisateurConnecte utilisateurConnecte, SiteEscalade siteEscalade, String titre,
      String message, Date dateEdition) {
    this.id = id;
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


