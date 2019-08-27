package metier;

import dao.SecteurDao;
import entities.Secteur;
import entities.SiteEscalade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
//    List<Secteur> secteurs = secteurDao.findAll().stream().filter(secteur -> secteur.getSiteEscalade().equals(siteEscalade.getSecteurs().contains()));
    return null;
  }
}
