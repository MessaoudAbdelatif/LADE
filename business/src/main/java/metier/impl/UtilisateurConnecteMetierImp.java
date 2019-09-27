package metier.impl;

import dao.RoleDao;
import dao.UtilisateurConnecteDao;
import entities.Role;
import entities.UtilisateurConnecte;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    UtilisateurConnecte utilisateurConnecteSelected = utilisateurConnecteDao.getOne(userName);
    if (utilisateurConnecteSelected == null) {
      throw new RuntimeException("Utilisateur Introuvable");
    }
    return utilisateurConnecteSelected;
  }

  @Override
  public void ajouterUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte) {
    List<Role> roles = new ArrayList<>();

    /* Ajouter Role USER à tous les nouveau membre et Role User & Admin aux ceux avec le prénom : Franck */

    roles.add(roleDao.findRolesByRoleContains("USER"));

    if (utilisateurConnecte.getPrenom().equals("Franck")) {
      roles.add(roleDao.findRolesByRoleContains("ADMIN"));
    }

    utilisateurConnecte.setRoles(roles);
    utilisateurConnecte.setEtatCompte(true);
    utilisateurConnecte.setDateCreation(LocalDateTime.now());
    utilisateurConnecteDao.save(utilisateurConnecte);
  }
}
