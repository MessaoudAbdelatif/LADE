package metier.contract;

import entities.DemandeLocation;
import metier.exception.ToposIntrouvableException;

public interface DemandeLocationMetier {

  DemandeLocation ajouterUneDemandeLocation(DemandeLocation demandeLocation);

  void updateUneDemandeLocation(DemandeLocation demandeLocation);

  DemandeLocation findDemandeLocationById(Long id);

  void accepterUneDemandeLocation(Long id)throws ToposIntrouvableException;

  void refuserUneDemandeLocation(Long id) throws ToposIntrouvableException;
}
