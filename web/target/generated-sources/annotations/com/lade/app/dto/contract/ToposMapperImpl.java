package com.lade.app.dto.contract;

import com.lade.app.dto.impl.ToposDto;
import entities.DemandeLocation;
import entities.Topos;
import entities.UtilisateurConnecte;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-22T03:19:15+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class ToposMapperImpl implements ToposMapper {

    @Override
    public Topos toTopos(ToposDto toposDto) {
        if ( toposDto == null ) {
            return null;
        }

        Topos topos = new Topos();

        topos.setUtilisateurConnecte( toposDtoToUtilisateurConnecte( toposDto ) );
        topos.setId( toposDto.getId() );
        topos.setNom( toposDto.getNom() );
        topos.setDescription( toposDto.getDescription() );
        topos.setLieuDeParution( toposDto.getLieuDeParution() );
        topos.setDateDeParution( toposDto.getDateDeParution() );
        topos.setLien( toposDto.getLien() );
        topos.setLoue( toposDto.getLoue() );
        List<DemandeLocation> list = toposDto.getDemandeLocations();
        if ( list != null ) {
            topos.setDemandeLocations( new ArrayList<DemandeLocation>( list ) );
        }

        return topos;
    }

    protected UtilisateurConnecte toposDtoToUtilisateurConnecte(ToposDto toposDto) {
        if ( toposDto == null ) {
            return null;
        }

        UtilisateurConnecte utilisateurConnecte = new UtilisateurConnecte();

        utilisateurConnecte.setUsername( toposDto.getUtilisateurConnecte() );

        return utilisateurConnecte;
    }
}
