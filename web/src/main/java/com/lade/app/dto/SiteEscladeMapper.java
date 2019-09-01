package com.lade.app.dto;

import entities.SiteEscalade;
import org.mapstruct.Mapper;

@Mapper
public interface SiteEscladeMapper {
SiteEscaladeDto map(SiteEscalade siteEscalade);
}
