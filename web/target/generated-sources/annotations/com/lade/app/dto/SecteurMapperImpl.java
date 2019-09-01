package com.lade.app.dto;

import entities.Secteur;
import entities.Voie;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-01T13:04:39+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
public class SecteurMapperImpl implements SecteurMapper {

    @Override
    public SecteurDto map(Secteur secteur) {
        if ( secteur == null ) {
            return null;
        }

        SecteurDto secteurDto = new SecteurDto();

        secteurDto.setNom( secteur.getNom() );
        secteurDto.setSiteEscalade( secteur.getSiteEscalade() );
        secteurDto.setDescription( secteur.getDescription() );
        Set<Voie> set = secteur.getVoies();
        if ( set != null ) {
            secteurDto.setVoies( new HashSet<Voie>( set ) );
        }

        return secteurDto;
    }
}
