package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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



@Entity
@Table(name = "Site_Escalade")
public class SiteEscalade implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

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
  private Set<Secteur> secteurs = new HashSet<>();

  @OneToMany(mappedBy = "siteEscalade",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Commentaire> commentaires = new HashSet<>();


  public SiteEscalade() {

  }

  public SiteEscalade( String nom, int nbrSecteur, String lieu, String villeProximite) {
    this.nom = nom;
    this.nbrSecteur = nbrSecteur;
    this.lieu = lieu;
    this.villeProximite = villeProximite;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public Set<Secteur> getSecteurs() {
    return secteurs;
  }

  public void setSecteurs(Set<Secteur> secteurs) {
    this.secteurs = secteurs;
  }

  public Set<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(Set<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }

  public SiteEscalade addSecteur( Secteur secteur){
    secteur.setSiteEscalade(this);
    this.secteurs.add(secteur);
    return this;
  }

}