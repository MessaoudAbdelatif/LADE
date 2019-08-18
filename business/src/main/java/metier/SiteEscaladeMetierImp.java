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
  public SiteEscalade consulterSiteEscalade(String nom) {
    SiteEscalade cse= siteEscaladeDao.getOne(nom);
    if (cse==null) throw new RuntimeException("Site Escalade Introuvable");
    return cse;
  }

  @Override
  public Page<SiteEscalade> rechercherUnSiteEscalade(int numPages, int size, String sei) {
    return siteEscaladeDao
        .findByNomContains(sei, PageRequest.of(numPages, size));
  }

  @Override
  public SiteEscalade AjouterModifierUnSiteEscalade(String nom) {
    return null;
  }
}
