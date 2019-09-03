package com.lade.app.dto;

import entities.Secteur;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SecteurMapper {

  @Mapping(target = "siteEscalade.id",source = "siteEscalade")
  Secteur toSecteur(SecteurDto secteurDto);
}
