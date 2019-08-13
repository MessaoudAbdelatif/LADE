package dao;

import entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireDao extends JpaRepository <Commentaire, Long>{

}
