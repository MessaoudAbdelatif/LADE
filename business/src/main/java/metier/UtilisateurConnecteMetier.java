package metier;


import entities.UtilisateurConnecte;

public interface UtilisateurConnecteMetier{
   UtilisateurConnecte consulterUtilisateurConnecte(String userName);
   void ajouterUtilisateurConnecte(UtilisateurConnecte utilisateurConnecte);

}
