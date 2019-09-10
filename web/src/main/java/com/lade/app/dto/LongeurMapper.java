package com.lade.app.dto;

import entities.Longeur;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LongeurMapper {

  @Mapping(target = "voie.id", source = "voie")
  Longeur toLongeur(LongeurDto longeurDto);
}
