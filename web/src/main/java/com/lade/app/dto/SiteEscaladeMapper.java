package com.lade.app.dto;

import entities.SiteEscalade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = SecteurMapper.class,  componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SiteEscaladeMapper {
//  SiteEscaladeDto map(SiteEscalade siteEscalade);
  SiteEscalade toSiteEscalade(SiteEscaladeDto siteEscaladeDto);
}
