package metier.contract;

import entities.DemandeLocation;

public interface DemandeLocationMetier {

  DemandeLocation ajouterUneDemandeLocation(DemandeLocation demandeLocation);

  void updateUneDemandeLocation(DemandeLocation demandeLocation);

  DemandeLocation findDemandeLocationById(Long id);
}
