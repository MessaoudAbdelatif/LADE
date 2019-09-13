package metier.impl;

import dao.UtilisateurConnecteDao;
import entities.UtilisateurConnecte;
import java.time.LocalDateTime;
import metier.contract.UtilisateurConnecteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UtilisateurConnecteMetierImp implements UtilisateurConnecteMetier {

  private final UtilisateurConnecteDao utilisateurConnecteDao;

  @Autowired
  public UtilisateurConnecteMetierImp(
      UtilisateurConnecteDao utilisateurConnecteDao) {
    this.utilisateurConnecteDao = utilisateurConnecteDao;
  }

  @Override
  public UtilisateurConnecte consulterUtilisateurConnecte(String userName) {
    return null;
  }

  @Override
  public void ajouterUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
    utilisateurConnecte.setDateCreation(LocalDateTime.now());
    utilisateurConnecteDao.save(utilisateurConnecte);
  }
}
