package metier.contract;

import entities.Longeur;

public interface LongeurMetier {
  Longeur ajouterUneLongeur(Longeur longeur);
  Longeur consulterUneLongeur(Long id);

}
