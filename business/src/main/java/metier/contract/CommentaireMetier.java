package metier.contract;

import entities.Commentaire;

public interface CommentaireMetier {

  Commentaire ajouterUnCommentaire(Commentaire commentaire);

  void updateUnCommentaire(Commentaire commentaire);

  void deleteCommentaire(Long commentaireId);
}
