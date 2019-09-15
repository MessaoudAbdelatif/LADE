package com.lade.app.dto.contract;

import com.lade.app.dto.impl.VoieDto;
import entities.Longeur;
import entities.Secteur;
import entities.Voie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-15T11:21:10+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class VoieMapperImpl implements VoieMapper {

    @Override
    public Voie toVoie(VoieDto voieDto) {
        if ( voieDto == null ) {
            return null;
        }

        Voie voie = new Voie();

        voie.setSecteur( voieDtoToSecteur( voieDto ) );
        voie.setId( voieDto.getId() );
        voie.setNom( voieDto.getNom() );
        voie.setDescreption( voieDto.getDescreption() );
        voie.setCotation( voieDto.getCotation() );
        List<Longeur> list = voieDto.getLongeurs();
        if ( list != null ) {
            voie.setLongeurs( new ArrayList<Longeur>( list ) );
        }

        return voie;
    }

    protected Secteur voieDtoToSecteur(VoieDto voieDto) {
        if ( voieDto == null ) {
            return null;
        }

        Secteur secteur = new Secteur();

        if ( voieDto.getSecteur() != null ) {
            secteur.setId( Long.parseLong( voieDto.getSecteur() ) );
        }

        return secteur;
    }
}
