package com.lade.app.dto.contract;

import com.lade.app.dto.impl.DemandeLocationDto;
import entities.DemandeLocation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DemandeLocationMapper  {

  @Mapping(target = "utilisateurConnecte.username",source = "utilisateurConnecte")
  @Mapping(target = "topos.id", source = "topos")
  DemandeLocation toDemandeLocation(DemandeLocationDto demandeLocationDto);

  @Mapping(target = "utilisateurConnecte",source = "utilisateurConnecte.username")
  @Mapping(target = "topos", source = "topos.id")
  DemandeLocationDto toDemandeLocationDto(DemandeLocation demandeLocation);

}
