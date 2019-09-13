package com.lade.app.dto.contract;

import com.lade.app.dto.impl.SecteurDto;
import entities.Secteur;
import entities.SiteEscalade;
import entities.Voie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-14T00:20:30+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class SecteurMapperImpl implements SecteurMapper {

    @Override
    public Secteur toSecteur(SecteurDto secteurDto) {
        if ( secteurDto == null ) {
            return null;
        }

        Secteur secteur = new Secteur();

        secteur.setSiteEscalade( secteurDtoToSiteEscalade( secteurDto ) );
        secteur.setNom( secteurDto.getNom() );
        secteur.setDescription( secteurDto.getDescription() );
        List<Voie> list = secteurDto.getVoies();
        if ( list != null ) {
            secteur.setVoies( new ArrayList<Voie>( list ) );
        }
        secteur.setId( secteurDto.getId() );

        return secteur;
    }

    protected SiteEscalade secteurDtoToSiteEscalade(SecteurDto secteurDto) {
        if ( secteurDto == null ) {
            return null;
        }

        SiteEscalade siteEscalade = new SiteEscalade();

        if ( secteurDto.getSiteEscalade() != null ) {
            siteEscalade.setId( Long.parseLong( secteurDto.getSiteEscalade() ) );
        }

        return siteEscalade;
    }
}