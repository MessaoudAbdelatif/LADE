package metier.contract;

import entities.Topos;
import java.util.List;
import metier.exception.ToposIntrouvableException;

public interface ToposMetier {

  Topos consulterUnTopos(Long id) throws ToposIntrouvableException;

  List<Topos> consulterAllTopos();

  void ajouterUnTopos(Topos topos);

}
