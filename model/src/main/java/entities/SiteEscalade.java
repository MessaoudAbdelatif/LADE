package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SiteEscalade implements Serializable {

  @Id
  private String nom;
  private int nbrSecteur;
  private String lieu;
  private String villeProximite;
  private String typeRoche;
  private boolean tag;
  @OneToMany(mappedBy = "nomSiteEscalade", fetch = FetchType.LAZY)
  private Collection<Secteur> secteurs;
  @OneToMany(mappedBy = "nomSiteEscalade", fetch = FetchType.LAZY)
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
    this.nbrSecteur = nbrSecteur;
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