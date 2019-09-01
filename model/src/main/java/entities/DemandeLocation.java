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
@Table(name = "Demande_Location")
public class DemandeLocation implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Date_Debut")
  private Date dateDebut;

  @Column(name = "Date_Fin")
  private Date dateFin;

  @Column(name = "Nom_Topos")
  private String nomTopos;

  @ManyToOne
  @JoinColumn(name = "Utilisateur_id")
  private UtilisateurConnecte utilisateurConnecte;


  @Column(name = "Message")
  private String message;

  @Column(name = "Proprio_Validation")
  private Boolean proprioValidation;

  public DemandeLocation() {
  }

  public DemandeLocation(Long id, Date dateDebut, Date dateFin, String nomTopos, UtilisateurConnecte utilisateurConnecte,
      String message, Boolean proprioValidation) {
    this.id = id;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.nomTopos = nomTopos;
    this.utilisateurConnecte = utilisateurConnecte;
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

  public UtilisateurConnecte getUserName() {
    return utilisateurConnecte;
  }

  public void setUserName(UtilisateurConnecte utilisateurConnecte) {
    this.utilisateurConnecte = utilisateurConnecte;
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
