package metier.impl;

import dao.RoleDao;
import dao.UtilisateurConnecteDao;
import entities.UtilisateurConnecte;
import java.time.LocalDateTime;
import metier.contract.UtilisateurConnecteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UtilisateurConnecteMetierImp implements UtilisateurConnecteMetier {

  private final UtilisateurConnecteDao utilisateurConnecteDao;
  private final RoleDao roleDao;

  @Autowired
  public UtilisateurConnecteMetierImp(
      UtilisateurConnecteDao utilisateurConnecteDao, RoleDao roleDao) {
    this.utilisateurConnecteDao = utilisateurConnecteDao;
    this.roleDao = roleDao;
  }

  @Override
  public UtilisateurConnecte consulterUtilisateurConnecte(String userName) {
    return null;
  }

  @Override
  public void ajouterUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
    utilisateurConnecte.setRoles(roleDao.findRolesByRoleContains("USER"));
    utilisateurConnecte.setEtatCompte(true);
    utilisateurConnecte.setDateCreation(LocalDateTime.now());
    utilisateurConnecteDao.save(utilisateurConnecte);
  }
}
