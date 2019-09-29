package metier.impl;

import dao.SecteurDao;
import entities.Secteur;
import entities.SiteEscalade;
import java.util.List;
import metier.contract.SecteurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecteurMetierImpl implements SecteurMetier {

  private SecteurDao secteurDao;


  @Autowired
  public SecteurMetierImpl(SecteurDao secteurDao) {
    this.secteurDao = secteurDao;

  }

  @Override
  public Secteur ajouterSecteur(Secteur secteur) {
    secteurDao.save(secteur);
    return secteur;
  }

  @Override
  public List<Secteur> consulterListSecteurPourUnSiteEscalade(SiteEscalade siteEscalade) {
    /*TODO*/
    return null;
  }


  @Override
  public Secteur consulterUnSecteur(Long id) {
    Secteur secteurSelected = secteurDao.getOne(id);
    if (secteurSelected == null) {
      throw new RuntimeException("Secteur Introuvable");
    }
    return secteurSelected;
  }
}
