package com.lade.app.dto.contract;

import com.lade.app.dto.impl.ToposDto;
import entities.Topos;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ToposMapper {
@Mapping(target = "utilisateurConnecte.userName",source = "utilisateurConnecte")
  Topos toTopos(ToposDto toposDto);
}
