package entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Demande_Location")
public class DemandeLocation implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "Date_Debut")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateDebut;

  @NotNull
  @Column(name = "Date_Fin")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateFin;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "Topos_id")
  private Topos topos;

  @ManyToOne
  @JoinColumn(name = "Utilisateur_id") /* il s'agit de l'utilisateur qui demande la location! */
  private UtilisateurConnecte utilisateurConnecte;


  @Column(name = "Message")
  private String message;

  @Column(name = "Proprio_Validation")
  private Boolean proprioValidation;

  public DemandeLocation() {
  }

  public DemandeLocation(LocalDate dateDebut, LocalDate dateFin, Topos topos,
      UtilisateurConnecte utilisateurConnecte, String message, Boolean proprioValidation) {
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.topos = topos;
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

  public LocalDate getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
  }

  public LocalDate getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
  }

  public Topos getTopos() {
    return topos;
  }

  public void setTopos(Topos topos) {
    this.topos = topos;
  }

  public UtilisateurConnecte getUtilisateurConnecte() {
    return utilisateurConnecte;
  }

  public void setUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
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
