package metier;

import entities.SiteEscalade;
import org.springframework.data.domain.Page;

public interface SiteEscaladeMetier {

  SiteEscalade consulterUnSiteEscalade(String nom);

  Page<SiteEscalade> rechercherDesSitesEscalades(int numPages, int size, String sei, String typeRecherche);

  void ajouterUnSiteEscalade(SiteEscalade siteEscalade);
  }
