package com.lade.app.dto;

import entities.Commentaire;
import entities.Secteur;
import entities.SiteEscalade;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-01T13:04:39+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
public class SiteEscladeMapperImpl implements SiteEscladeMapper {

    @Override
    public SiteEscaladeDto map(SiteEscalade siteEscalade) {
        if ( siteEscalade == null ) {
            return null;
        }

        SiteEscaladeDto siteEscaladeDto = new SiteEscaladeDto();

        siteEscaladeDto.setNom( siteEscalade.getNom() );
        siteEscaladeDto.setNbrSecteur( siteEscalade.getNbrSecteur() );
        siteEscaladeDto.setLieu( siteEscalade.getLieu() );
        siteEscaladeDto.setVilleProximite( siteEscalade.getVilleProximite() );
        siteEscaladeDto.setTypeRoche( siteEscalade.getTypeRoche() );
        siteEscaladeDto.setTag( siteEscalade.isTag() );
        Set<Secteur> set = siteEscalade.getSecteurs();
        if ( set != null ) {
            siteEscaladeDto.setSecteurs( new HashSet<Secteur>( set ) );
        }
        Set<Commentaire> set1 = siteEscalade.getCommentaires();
        if ( set1 != null ) {
            siteEscaladeDto.setCommentaires( new HashSet<Commentaire>( set1 ) );
        }

        return siteEscaladeDto;
    }
}
