package metier.impl;

import dao.ToposDao;
import entities.Topos;
import java.util.List;
import metier.contract.ToposMetier;
import org.springframework.stereotype.Service;

@Service
public class ToposMetierImpl implements ToposMetier {

  private final ToposDao toposDao;

  public ToposMetierImpl(ToposDao toposDao) {
    this.toposDao = toposDao;
  }

  @Override
  public Topos consulterUnTopos(Long id) {
    Topos topos = toposDao.getOne(id);
    if (topos == null) {
      throw new RuntimeException("Topos Introuvable !!");
    }
    return topos;
  }

  @Override
  public List<Topos> consulterAllTopos() {
    return toposDao.findAll();
  }

  @Override
  public void ajouterUnTopos(Topos topos) {
    toposDao.save(topos);
  }
}
