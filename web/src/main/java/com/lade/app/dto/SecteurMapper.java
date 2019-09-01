package com.lade.app.dto;

import entities.Secteur;
import org.mapstruct.Mapper;

@Mapper
public interface SecteurMapper {
SecteurDto map(Secteur secteur);
}
