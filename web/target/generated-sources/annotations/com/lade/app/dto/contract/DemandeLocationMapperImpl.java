package com.lade.app.dto.contract;

import com.lade.app.dto.impl.DemandeLocationDto;
import entities.DemandeLocation;
import entities.Topos;
import entities.UtilisateurConnecte;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-30T00:59:23+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class DemandeLocationMapperImpl implements DemandeLocationMapper {

    @Override
    public DemandeLocation toDemandeLocation(DemandeLocationDto demandeLocationDto) {
        if ( demandeLocationDto == null ) {
            return null;
        }

        DemandeLocation demandeLocation = new DemandeLocation();

        demandeLocation.setUtilisateurConnecte( demandeLocationDtoToUtilisateurConnecte( demandeLocationDto ) );
        demandeLocation.setTopos( demandeLocationDtoToTopos( demandeLocationDto ) );
        demandeLocation.setId( demandeLocationDto.getId() );
        if ( demandeLocationDto.getDateDebut() != null ) {
            demandeLocation.setDateDebut( LocalDate.parse( demandeLocationDto.getDateDebut() ) );
        }
        if ( demandeLocationDto.getDateFin() != null ) {
            demandeLocation.setDateFin( LocalDate.parse( demandeLocationDto.getDateFin() ) );
        }
        demandeLocation.setMessage( demandeLocationDto.getMessage() );
        demandeLocation.setProprioValidation( demandeLocationDto.getProprioValidation() );

        return demandeLocation;
    }

    @Override
    public DemandeLocationDto toDemandeLocationDto(DemandeLocation demandeLocation) {
        if ( demandeLocation == null ) {
            return null;
        }

        DemandeLocationDto demandeLocationDto = new DemandeLocationDto();

        demandeLocationDto.setUtilisateurConnecte( demandeLocationUtilisateurConnecteUsername( demandeLocation ) );
        demandeLocationDto.setTopos( demandeLocationToposId( demandeLocation ) );
        demandeLocationDto.setId( demandeLocation.getId() );
        if ( demandeLocation.getDateDebut() != null ) {
            demandeLocationDto.setDateDebut( DateTimeFormatter.ISO_LOCAL_DATE.format( demandeLocation.getDateDebut() ) );
        }
        if ( demandeLocation.getDateFin() != null ) {
            demandeLocationDto.setDateFin( DateTimeFormatter.ISO_LOCAL_DATE.format( demandeLocation.getDateFin() ) );
        }
        demandeLocationDto.setMessage( demandeLocation.getMessage() );
        demandeLocationDto.setProprioValidation( demandeLocation.getProprioValidation() );

        return demandeLocationDto;
    }

    protected UtilisateurConnecte demandeLocationDtoToUtilisateurConnecte(DemandeLocationDto demandeLocationDto) {
        if ( demandeLocationDto == null ) {
            return null;
        }

        UtilisateurConnecte utilisateurConnecte = new UtilisateurConnecte();

        utilisateurConnecte.setUsername( demandeLocationDto.getUtilisateurConnecte() );

        return utilisateurConnecte;
    }

    protected Topos demandeLocationDtoToTopos(DemandeLocationDto demandeLocationDto) {
        if ( demandeLocationDto == null ) {
            return null;
        }

        Topos topos = new Topos();

        topos.setId( demandeLocationDto.getTopos() );

        return topos;
    }

    private String demandeLocationUtilisateurConnecteUsername(DemandeLocation demandeLocation) {
        if ( demandeLocation == null ) {
            return null;
        }
        UtilisateurConnecte utilisateurConnecte = demandeLocation.getUtilisateurConnecte();
        if ( utilisateurConnecte == null ) {
            return null;
        }
        String username = utilisateurConnecte.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private Long demandeLocationToposId(DemandeLocation demandeLocation) {
        if ( demandeLocation == null ) {
            return null;
        }
        Topos topos = demandeLocation.getTopos();
        if ( topos == null ) {
            return null;
        }
        Long id = topos.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
