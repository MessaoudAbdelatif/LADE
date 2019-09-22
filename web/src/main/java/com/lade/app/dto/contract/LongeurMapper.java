package com.lade.app.dto.contract;

import com.lade.app.dto.impl.LongeurDto;
import entities.Longeur;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LongeurMapper {

  @Mapping(target = "voie.id", source = "voie")
  Longeur toLongeur(LongeurDto longeurDto);

  @Mapping(target = "voie", source = "voie.id")
  LongeurDto toLongeurDto(Longeur longeur);
}
