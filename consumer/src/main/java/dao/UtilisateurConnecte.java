package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurConnecte extends JpaRepository<entities.UtilisateurConnecte, String> {

}
