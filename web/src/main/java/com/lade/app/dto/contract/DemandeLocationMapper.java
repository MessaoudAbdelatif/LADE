package com.lade.app.dto.contract;

import com.lade.app.dto.impl.DemandeLocationDto;
import entities.DemandeLocation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DemandeLocationMapper {

  @Mapping(target = "utilisateurConnecte.username", source = "utilisateurConnecte")
  @Mapping(target = "topos.id", source = "topos")
  /*
  @Mapping(target = "dateDebut", dateFormat = "yyyy/MM/dd")
  @Mapping(target = "dateFin", dateFormat = "yyyy/MM/dd")
  */
  DemandeLocation toDemandeLocation(DemandeLocationDto demandeLocationDto);

  @Mapping(target = "utilisateurConnecte", source = "utilisateurConnecte.username")
  @Mapping(target = "topos", source = "topos.id")
  /*@Mapping(target = "dateDebut", dateFormat = "yyyy/MM/dd")
  @Mapping(target = "dateFin", dateFormat = "yyyy/MM/dd")*/
  DemandeLocationDto toDemandeLocationDto(DemandeLocation demandeLocation);

}
