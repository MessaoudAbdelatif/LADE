package entities;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class MembreAssociation extends UtilisateurConnecte {

  public MembreAssociation() {
    super();
  }

  public MembreAssociation(String userName, String civilite, String nom, String prenom,
      String presentationPersonel, String email, Boolean etatCompte, String motDePasse,
      Date dateCreation) {
  }

  @Override
  public String getUserName() {
    return super.getUserName();
  }

  @Override
  public void setUserName(String userName) {
    super.setUserName(userName);
  }

  @Override
  public String getCivilite() {
    return super.getCivilite();
  }

  @Override
  public void setCivilite(String civilite) {
    super.setCivilite(civilite);
  }

  @Override
  public String getNom() {
    return super.getNom();
  }

  @Override
  public void setNom(String nom) {
    super.setNom(nom);
  }

  @Override
  public String getPrenom() {
    return super.getPrenom();
  }

  @Override
  public void setPrenom(String prenom) {
    super.setPrenom(prenom);
  }

  @Override
  public String getPresentationPersonel() {
    return super.getPresentationPersonel();
  }

  @Override
  public void setPresentationPersonel(String presentationPersonel) {
    super.setPresentationPersonel(presentationPersonel);
  }

  @Override
  public String getEmail() {
    return super.getEmail();
  }

  @Override
  public void setEmail(String email) {
    super.setEmail(email);
  }

  @Override
  public Boolean getEtatCompte() {
    return super.getEtatCompte();
  }

  @Override
  public void setEtatCompte(Boolean etatCompte) {
    super.setEtatCompte(etatCompte);
  }

  @Override
  public String getMotDePasse() {
    return super.getMotDePasse();
  }

  @Override
  public void setMotDePasse(String motDePasse) {
    super.setMotDePasse(motDePasse);
  }

  @Override
  public Date getDateCreation() {
    return super.getDateCreation();
  }

  @Override
  public void setDateCreation(Date dateCreation) {
    super.setDateCreation(dateCreation);
  }
}
