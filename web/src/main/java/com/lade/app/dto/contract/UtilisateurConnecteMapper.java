package com.lade.app.dto.contract;

import com.lade.app.dto.impl.UtilisateurConnecteDto;
import entities.UtilisateurConnecte;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(uses = ToposMapper.class ,componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UtilisateurConnecteMapper {

  UtilisateurConnecte toUtilisateurConnecte(UtilisateurConnecteDto utilisateurConnecteDto);

  UtilisateurConnecteDto toUtilisateurConnecteDto(UtilisateurConnecte utilisateurConnecte);
}
