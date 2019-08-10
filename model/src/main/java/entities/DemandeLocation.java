package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DemandeLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date dateDebut;
  private Date dateFin;
  private String nomTopos;
  private String userName;
  private String message;
  private Boolean proprioValidation;

  public DemandeLocation() {
  }

  public DemandeLocation(Long id, Date dateDebut, Date dateFin, String nomTopos, String userName,
      String message, Boolean proprioValidation) {
    this.id = id;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.nomTopos = nomTopos;
    this.userName = userName;
    this.message = message;
    this.proprioValidation = proprioValidation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String getNomTopos() {
    return nomTopos;
  }

  public void setNomTopos(String nomTopos) {
    this.nomTopos = nomTopos;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getProprioValidation() {
    return proprioValidation;
  }

  public void setProprioValidation(Boolean proprioValidation) {
    this.proprioValidation = proprioValidation;
  }
}
