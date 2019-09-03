package metier;

import entities.SiteEscalade;
import org.springframework.data.domain.Page;

public interface SiteEscaladeMetier {

  SiteEscalade consulterUnSiteEscalade(long id);

  Page<SiteEscalade> rechercherDesSitesEscalades(int numPages, int size, String sei, String typeRecherche);

  void ajouterUnSiteEscalade(SiteEscalade siteEscalade);

  SiteEscalade updateSiteEscalade(Long id, SiteEscalade siteEscalade);
  }
