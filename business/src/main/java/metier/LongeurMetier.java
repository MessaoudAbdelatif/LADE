package metier;

import entities.Longeur;

public interface LongeurMetier {
  Longeur ajouterUneLongeur(Longeur longeur);
  Longeur consulterUneLongeur(Long id);

}
