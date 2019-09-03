package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Site_Escalade")
public class SiteEscalade implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "Nom")
  private String nom;

  @Column(name = "Nombre_Secteur")
  private int nbrSecteur;

  @Column(name = "Lieu")
  @NotEmpty
  private String lieu;

  @Column(name = "Ville_Proximite")
  private String villeProximite;

  @Column(name = "Type_Roche")
  private String typeRoche;

  @Column(name = "Tag")
  private boolean tag;

  @OneToMany(mappedBy = "siteEscalade",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Secteur> secteurs;

  @OneToMany(mappedBy = "siteEscalade",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Commentaire> commentaires;


  public SiteEscalade() {

  }

  public SiteEscalade(@NotEmpty String nom, int nbrSecteur,
      @NotEmpty String lieu, String villeProximite, String typeRoche, boolean tag,
      List<Secteur> secteurs, List<Commentaire> commentaires) {
    this.nom = nom;
    this.nbrSecteur = nbrSecteur;
    this.lieu = lieu;
    this.villeProximite = villeProximite;
    this.typeRoche = typeRoche;
    this.tag = tag;
    this.secteurs = secteurs;
    this.commentaires = commentaires;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getNbrSecteur() {
    return nbrSecteur;
  }

  public void setNbrSecteur(int nbrSecteur) {
    if (secteurs.isEmpty()) {
      this.nbrSecteur = 0;
    }
    this.nbrSecteur = secteurs.size();
  }

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

  public String getVilleProximite() {
    return villeProximite;
  }

  public void setVilleProximite(String villeProximite) {
    this.villeProximite = villeProximite;
  }

  public String getTypeRoche() {
    return typeRoche;
  }

  public void setTypeRoche(String typeRoche) {
    this.typeRoche = typeRoche;
  }

  public boolean isTag() {
    return tag;
  }

  public void setTag(boolean tag) {
    this.tag = tag;
  }

  public List<Secteur> getSecteurs() {
    return secteurs;
  }

  public void setSecteurs(List<Secteur> secteurs) {
    this.secteurs = secteurs;
  }

  public List<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(List<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }

  public SiteEscalade addSecteur( @NotNull Secteur secteur){
    secteur.setSiteEscalade(this);
    this.secteurs.add(secteur);
    return this;
  }

}