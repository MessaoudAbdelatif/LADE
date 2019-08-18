package metier;

import dao.UtilisateurConnecteDao;
import entities.UtilisateurConnecte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
    utilisateurConnecteDao.save(utilisateurConnecte);
  }
}
