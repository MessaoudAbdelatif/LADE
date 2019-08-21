package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity
public class SiteEscalade implements Serializable {

  @Id
  @Column(unique = true)
  @NotEmpty
  private String nom;
  private int nbrSecteur;
  @NotEmpty
  private String lieu;
  private String villeProximite;
  private String typeRoche;
  private boolean tag;
  @OneToMany(mappedBy = "siteEscalade", fetch = FetchType.LAZY)
  private Collection<Secteur> secteurs;
  @OneToMany(mappedBy = "siteEscalade", fetch = FetchType.LAZY)
  private Collection<Commentaire> commentaires;


  public SiteEscalade() {

  }

  public SiteEscalade(String nom, String lieu, String villeProximite) {
    this.nom = nom;
    this.lieu = lieu;
    this.villeProximite = villeProximite;
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

  public Collection<Secteur> getSecteurs() {
    return secteurs;
  }

  public void setSecteurs(Collection<Secteur> secteurs) {
    this.secteurs = secteurs;
  }

  public Collection<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(Collection<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }
}