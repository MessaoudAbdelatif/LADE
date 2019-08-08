package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Commentaire implements Serializable {

  @Id
  private Integer id;
  private String userName;
  private String nomSiteEscalade;
  private String titre;
  private String message;
  private Date dateEdition;

  public Commentaire() {
  }

  public Commentaire(Integer id, String userName, String nomSiteEscalade, String titre,
      String message, Date dateEdition) {
    this.id = id;
    this.userName = userName;
    this.nomSiteEscalade = nomSiteEscalade;
    this.titre = titre;
    this.message = message;
    this.dateEdition = dateEdition;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNomSiteEscalade() {
    return nomSiteEscalade;
  }

  public void setNomSiteEscalade(String nomSiteEscalade) {
    this.nomSiteEscalade = nomSiteEscalade;
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


