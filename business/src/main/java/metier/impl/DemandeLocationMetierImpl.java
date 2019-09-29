package metier.impl;

import dao.DemandeLocationDao;
import entities.DemandeLocation;
import entities.Topos;
import java.util.Optional;
import metier.contract.DemandeLocationMetier;
import metier.contract.ToposMetier;
import metier.exception.ToposIntrouvableException;
import org.springframework.stereotype.Service;

@Service
public class DemandeLocationMetierImpl implements DemandeLocationMetier {

  private DemandeLocationDao demandeLocationDao;
  private ToposMetier toposMetier;

  public DemandeLocationMetierImpl(DemandeLocationDao demandeLocationDao,
      ToposMetier toposMetier) {
    this.demandeLocationDao = demandeLocationDao;
    this.toposMetier = toposMetier;
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

  @Override
  public void accepterUneDemandeLocation(Long id) throws ToposIntrouvableException {
    DemandeLocation demandeLocationSelected = findDemandeLocationById(id);
    demandeLocationSelected.setProprioValidation(true);
    Topos unTopos = toposMetier.consulterUnTopos(demandeLocationSelected.getTopos().getId());
    unTopos.setDisponibleEnLocation(false);
    updateUneDemandeLocation(demandeLocationSelected);
    toposMetier.updateTopos(unTopos);
  }

  @Override
  public void refuserUneDemandeLocation(Long id) throws ToposIntrouvableException {
    DemandeLocation demandeLocationSelected = findDemandeLocationById(id);
    demandeLocationSelected.setProprioValidation(false);
    Topos unTopos = toposMetier.consulterUnTopos(demandeLocationSelected.getTopos().getId());
    unTopos.setDisponibleEnLocation(true);
    updateUneDemandeLocation(demandeLocationSelected);
    toposMetier.updateTopos(unTopos);
  }

}
