package metier.impl;

import dao.CommentaireDao;
import entities.Commentaire;
import java.time.Instant;
import java.util.Date;
import metier.contract.CommentaireMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentaireMetierImpl implements CommentaireMetier {

  private CommentaireDao commentaireDao;

  @Autowired
  public CommentaireMetierImpl(CommentaireDao commentaireDao) {
    this.commentaireDao = commentaireDao;
  }

  @Override
  public Commentaire ajouterUnCommentaire(Commentaire commentaire) {
    commentaire.setDateCreation(Date.from(Instant.now()));
    commentaireDao.save(commentaire);
    return commentaire;
  }

  @Override
  public Commentaire findCommentaireById(Long id) {
    return commentaireDao.getOne(id);
  }

  @Override
  public void updateUnCommentaire(Commentaire commentaire) {
    commentaireDao.save(commentaire);
  }


  @Override
  public void deleteCommentaire(Long commentaireId) {
    commentaireDao.deleteById(commentaireId);
  }
}
