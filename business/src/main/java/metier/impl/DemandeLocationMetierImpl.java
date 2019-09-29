package metier.impl;

import dao.DemandeLocationDao;
import entities.DemandeLocation;
import java.util.Optional;
import metier.contract.DemandeLocationMetier;
import org.springframework.stereotype.Service;

@Service
public class DemandeLocationMetierImpl implements DemandeLocationMetier {

  private DemandeLocationDao demandeLocationDao;

  public DemandeLocationMetierImpl(DemandeLocationDao demandeLocationDao) {
    this.demandeLocationDao = demandeLocationDao;
  }

  @Override
  public DemandeLocation ajouterUneDemandeLocation(DemandeLocation demandeLocation) {
    demandeLocationDao.save(demandeLocation);
    return demandeLocation;
  }

  @Override
  public void updateUneDemandeLocation(DemandeLocation demandeLocation) {
    demandeLocationDao.save(demandeLocation);
  }

  @Override
  public DemandeLocation findDemandeLocationById(Long id) {

    if (id != null) {
        Optional<DemandeLocation> demandeLocationSelected = demandeLocationDao.findById(id);
      if (demandeLocationSelected.isPresent()) {
        return demandeLocationSelected.get();
      }
    }
    return null;
  }
}
