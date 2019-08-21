package metier;

import entities.Secteur;
import entities.SiteEscalade;
import java.util.List;

public interface SecteurMetier {
void ajouterSecteur(Secteur secteur);
List<Secteur> consulterListSecteur(SiteEscalade siteEscalade);
}
