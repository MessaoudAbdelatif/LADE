package metier.contract;

import entities.Secteur;
import entities.SiteEscalade;
import java.util.List;

public interface SecteurMetier {

  Secteur ajouterSecteur(Secteur secteur);

  List<Secteur> consulterListSecteurPourUnSiteEscalade(SiteEscalade siteEscalade);

  Secteur consulterUnSecteur(Long id);
}
