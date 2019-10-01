package com.lade.app.dto.contract;

import com.lade.app.dto.impl.CommentaireDto;
import entities.Commentaire;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CommentaireMapper {

  @Mapping(target = "utilisateurConnecte.username", source = "utilisateurConnecte")
  @Mapping(target = "siteEscalade.id", source = "siteEscalade")
  Commentaire toCommentaire(CommentaireDto commentaireDto);

  @Mapping(target = "utilisateurConnecte", source = "utilisateurConnecte.username")
  @Mapping(target = "siteEscalade", source = "siteEscalade.id")
  CommentaireDto toCommentaireDto(Commentaire commentaire);

}
