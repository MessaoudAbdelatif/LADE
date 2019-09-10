package metier;

import dao.LongeurDao;
import entities.Longeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LongeurMetierImp implements LongeurMetier {


  private LongeurDao longeurDao;

  @Autowired
  public LongeurMetierImp(LongeurDao longeurDao) {
    this.longeurDao = longeurDao;
  }

  @Override
  public Longeur ajouterUneLongeur(Longeur longeur) {
    longeurDao.save(longeur);
    return longeur;
  }

  @Override
  public Longeur consulterUneLongeur(Long id) {
    Longeur longeurSelected = longeurDao.getOne(id);
    if (longeurSelected == null) {
      throw new RuntimeException("Longeur Introuvable");
    }
    return longeurSelected;
  }

}
