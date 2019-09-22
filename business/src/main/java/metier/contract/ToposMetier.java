package metier.contract;

import entities.Topos;
import java.util.List;

public interface ToposMetier {

  Topos consulterUnTopos(Long id);

  List<Topos> consulterAllTopos();

  void ajouterUnTopos(Topos topos);

}
