package metier.impl;

import dao.ToposDao;
import entities.Topos;
import java.util.List;
import java.util.Optional;
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

    if (id != null) {
      Optional<Topos> toposSelected = toposDao.findById(id);
      if (toposSelected.isPresent()) {
        return toposSelected.get();
      }
      throw new ToposIntrouvableException("Topos Introuvable !!");
    }
    return null;
  }

  @Override
  public List<Topos> consulterAllTopos() {
    return toposDao.findAll();
  }

  @Override
  public Topos ajouterUnTopos(Topos topos) {
    toposDao.save(topos);
    return topos;
  }

  @Override
  public void updateTopos(Topos topos) {
    toposDao.save(topos);
  }
}
