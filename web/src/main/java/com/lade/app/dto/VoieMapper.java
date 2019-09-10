package com.lade.app.dto;

import entities.Voie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = LongeurMapper.class, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VoieMapper {

  @Mapping(target = "secteur.id", source = "secteur")
  Voie toVoie(VoieDto voieDto);
}
