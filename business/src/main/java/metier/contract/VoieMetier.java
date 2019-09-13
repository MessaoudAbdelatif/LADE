package metier.contract;

import entities.Voie;
import java.util.Collection;

public interface VoieMetier {

  Voie ajouterVoie(Voie voie);

  Collection<Voie> afficherListeToutesVoieBySecteur();

  Voie consulterUneVoie(Long id);
}
