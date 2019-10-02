package metier.contract;

import entities.Commentaire;

public interface CommentaireMetier {

  Commentaire ajouterUnCommentaire(Commentaire commentaire);

  void updateUnCommentaire(String titre,String message,Long id);

  void deleteCommentaire(Long commentaireId);

  Commentaire findCommentaireById(Long id);

}
