package metier.impl;

import dao.ToposDao;
import entities.Topos;
import java.util.List;
import metier.contract.ToposMetier;
import metier.exception.ToposIntrouvableException;
import org.springframework.stereotype.Service;

@Service
public class ToposMetierImpl implements ToposMetier {

  private final ToposDao toposDao;

  public ToposMetierImpl(ToposDao toposDao) {
    this.toposDao = toposDao;
  }

  @Override
  public Topos consulterUnTopos(Long id) throws ToposIntrouvableException {

    if (toposDao.getOne(id) == null) {
      throw new ToposIntrouvableException("Topos Introuvable !!");
    }
    return toposDao.getOne(id);
  }






   /* if (topos == null) {
      throw new ToposIntrouvableException("Topos Introuvable !!");
    }*/


  @Override
  public List<Topos> consulterAllTopos() {
    return toposDao.findAll();
  }

  @Override
  public void ajouterUnTopos(Topos topos) {
    toposDao.save(topos);
  }
}
