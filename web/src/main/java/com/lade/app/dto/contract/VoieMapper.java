package com.lade.app.dto.contract;

import com.lade.app.dto.impl.VoieDto;
import entities.Voie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = LongeurMapper.class, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VoieMapper {

  @Mapping(target = "secteur.id", source = "secteur")
  Voie toVoie(VoieDto voieDto);
}
