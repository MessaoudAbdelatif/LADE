package dao;

import entities.UtilisateurConnecte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurConnecteDao extends JpaRepository<UtilisateurConnecte, String> {

}
