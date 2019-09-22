package com.lade.app.dto.contract;

import com.lade.app.dto.impl.LongeurDto;
import entities.Longeur;
import entities.Voie;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-22T02:56:45+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class LongeurMapperImpl implements LongeurMapper {

    @Override
    public Longeur toLongeur(LongeurDto longeurDto) {
        if ( longeurDto == null ) {
            return null;
        }

        Longeur longeur = new Longeur();

        longeur.setVoie( longeurDtoToVoie( longeurDto ) );
        longeur.setId( longeurDto.getId() );
        longeur.setNom( longeurDto.getNom() );
        longeur.setCotation( longeurDto.getCotation() );

        return longeur;
    }

    protected Voie longeurDtoToVoie(LongeurDto longeurDto) {
        if ( longeurDto == null ) {
            return null;
        }

        Voie voie = new Voie();

        if ( longeurDto.getVoie() != null ) {
            voie.setId( Long.parseLong( longeurDto.getVoie() ) );
        }

        return voie;
    }
}
