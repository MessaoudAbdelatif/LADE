package com.lade.app.dto.contract;

import com.lade.app.dto.impl.SiteEscaladeDto;
import entities.SiteEscalade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = SecteurMapper.class,  componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SiteEscaladeMapper {
   SiteEscalade toSiteEscalade(SiteEscaladeDto siteEscaladeDto);
}
