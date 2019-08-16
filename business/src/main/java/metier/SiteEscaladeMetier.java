package metier;

import entities.SiteEscalade;
import org.springframework.data.domain.Page;

public interface SiteEscaladeMetier {
   SiteEscalade consulterSiteEscalade(String nom);
   Page<SiteEscalade> rechercherUnSiteEscalade(int numPages, int size, String sei);


}
