package metier;

import dao.SiteEscaladeDao;
import entities.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SiteEscaladeMetierImp implements SiteEscaladeMetier {

  @Autowired
  private SiteEscaladeDao siteEscaladeDao;

  @Override
  public SiteEscalade consulterSiteEscalade(String nom) {
    SiteEscalade cse= siteEscaladeDao.getOne(nom);
    if (cse==null) throw new RuntimeException("Site Escalade Introuvable");
    return cse;
  }
}
