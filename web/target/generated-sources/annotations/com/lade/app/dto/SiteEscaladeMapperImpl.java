package com.lade.app.dto;

import entities.Commentaire;
import entities.Secteur;
import entities.SiteEscalade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-10T02:24:03+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class SiteEscaladeMapperImpl implements SiteEscaladeMapper {

    @Override
    public SiteEscalade toSiteEscalade(SiteEscaladeDto siteEscaladeDto) {
        if ( siteEscaladeDto == null ) {
            return null;
        }

        SiteEscalade siteEscalade = new SiteEscalade();

        siteEscalade.setId( siteEscaladeDto.getId() );
        siteEscalade.setNom( siteEscaladeDto.getNom() );
        if ( siteEscaladeDto.getNbrSecteur() != null ) {
            siteEscalade.setNbrSecteur( siteEscaladeDto.getNbrSecteur() );
        }
        siteEscalade.setLieu( siteEscaladeDto.getLieu() );
        siteEscalade.setVilleProximite( siteEscaladeDto.getVilleProximite() );
        siteEscalade.setTypeRoche( siteEscaladeDto.getTypeRoche() );
        if ( siteEscaladeDto.getTag() != null ) {
            siteEscalade.setTag( siteEscaladeDto.getTag() );
        }
        List<Secteur> list = siteEscaladeDto.getSecteurs();
        if ( list != null ) {
            siteEscalade.setSecteurs( new ArrayList<Secteur>( list ) );
        }
        List<Commentaire> list1 = siteEscaladeDto.getCommentaires();
        if ( list1 != null ) {
            siteEscalade.setCommentaires( new ArrayList<Commentaire>( list1 ) );
        }

        return siteEscalade;
    }
}
