package metier;

import dao.SiteEscaladeDao;
import entities.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SiteEscaladeMetierImp implements SiteEscaladeMetier {

  private SiteEscaladeDao siteEscaladeDao;

  @Autowired
  public SiteEscaladeMetierImp(
      SiteEscaladeDao siteEscaladeDao) {
    this.siteEscaladeDao = siteEscaladeDao;
  }

  @Override
  public SiteEscalade consulterUnSiteEscalade(Long id) {
    SiteEscalade cse = siteEscaladeDao.getOne(id);
    if (cse == null) {
      throw new RuntimeException("Site Escalade Introuvable");
    }
    cse.setNbrSecteur(cse.getSecteurs().size());   // Me permet d'update le nombre de secteur.
    return cse;
  }

  @Override
  public Page<SiteEscalade> rechercherDesSitesEscalades(int numPages, int size, String sei,
      String typeRecherche) {
    switch (typeRecherche) {
      case "VILLEPROX":
        return siteEscaladeDao
            .findByVilleProximiteContainsIgnoreCase(sei, PageRequest.of(numPages, size));
      case "LIEU":
        return siteEscaladeDao
            .findByLieuContainsIgnoreCase(sei, PageRequest.of(numPages, size));
      default:
        return siteEscaladeDao
            .findByNomContainsIgnoreCaseOrderByNom(sei, PageRequest.of(numPages, size));
    }
  }

  @Override
  public void ajouterUnSiteEscalade(SiteEscalade siteEscalade) {
    siteEscaladeDao.save(siteEscalade);
  }

  @Override
  public SiteEscalade updateSiteEscalade(Long id, SiteEscalade siteEscalade) {
    SiteEscalade siteEscaladeToUpdate = consulterUnSiteEscalade(id);
    siteEscaladeToUpdate = siteEscaladeDao.save(siteEscalade);
    return siteEscaladeToUpdate;
  }
}
