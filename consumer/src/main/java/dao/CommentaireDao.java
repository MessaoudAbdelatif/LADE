package dao;

import entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentaireDao extends JpaRepository<Commentaire, Long> {

  @Modifying
  @Query("UPDATE Commentaire c SET c.titre = :titre, c.message = :message WHERE c.id = :id")
  void updateCommentaire(@Param("id") Long id, @Param("titre") String titre, @Param("message") String message);
}
