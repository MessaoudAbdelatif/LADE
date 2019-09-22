package com.lade.app.dto.contract;

import com.lade.app.dto.impl.UtilisateurConnecteDto;
import entities.Commentaire;
import entities.DemandeLocation;
import entities.Role;
import entities.Topos;
import entities.UtilisateurConnecte;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-22T01:04:14+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class UtilisateurConnecteMapperImpl implements UtilisateurConnecteMapper {

    @Override
    public UtilisateurConnecte toUtilisateurConnecte(UtilisateurConnecteDto utilisateurConnecteDto) {
        if ( utilisateurConnecteDto == null ) {
            return null;
        }

        UtilisateurConnecte utilisateurConnecte = new UtilisateurConnecte();

        utilisateurConnecte.setUsername( utilisateurConnecteDto.getUsername() );
        utilisateurConnecte.setCivilite( utilisateurConnecteDto.getCivilite() );
        utilisateurConnecte.setNom( utilisateurConnecteDto.getNom() );
        utilisateurConnecte.setPrenom( utilisateurConnecteDto.getPrenom() );
        utilisateurConnecte.setPresentationPersonel( utilisateurConnecteDto.getPresentationPersonel() );
        utilisateurConnecte.setEmail( utilisateurConnecteDto.getEmail() );
        utilisateurConnecte.setEtatCompte( utilisateurConnecteDto.getEtatCompte() );
        utilisateurConnecte.setMotDePasse( utilisateurConnecteDto.getMotDePasse() );
        utilisateurConnecte.setDateCreation( utilisateurConnecteDto.getDateCreation() );
        List<DemandeLocation> list = utilisateurConnecteDto.getDemandeLocations();
        if ( list != null ) {
            utilisateurConnecte.setDemandeLocations( new ArrayList<DemandeLocation>( list ) );
        }
        List<Commentaire> list1 = utilisateurConnecteDto.getCommentaires();
        if ( list1 != null ) {
            utilisateurConnecte.setCommentaires( new ArrayList<Commentaire>( list1 ) );
        }
        List<Topos> list2 = utilisateurConnecteDto.getTopos();
        if ( list2 != null ) {
            utilisateurConnecte.setTopos( new ArrayList<Topos>( list2 ) );
        }
        List<Role> list3 = utilisateurConnecteDto.getRoles();
        if ( list3 != null ) {
            utilisateurConnecte.setRoles( new ArrayList<Role>( list3 ) );
        }

        return utilisateurConnecte;
    }

    @Override
    public UtilisateurConnecteDto toUtilisateurConnecteDto(UtilisateurConnecte utilisateurConnecte) {
        if ( utilisateurConnecte == null ) {
            return null;
        }

        UtilisateurConnecteDto utilisateurConnecteDto = new UtilisateurConnecteDto();

        utilisateurConnecteDto.setUsername( utilisateurConnecte.getUsername() );
        utilisateurConnecteDto.setCivilite( utilisateurConnecte.getCivilite() );
        utilisateurConnecteDto.setNom( utilisateurConnecte.getNom() );
        utilisateurConnecteDto.setPrenom( utilisateurConnecte.getPrenom() );
        utilisateurConnecteDto.setPresentationPersonel( utilisateurConnecte.getPresentationPersonel() );
        utilisateurConnecteDto.setEmail( utilisateurConnecte.getEmail() );
        utilisateurConnecteDto.setEtatCompte( utilisateurConnecte.getEtatCompte() );
        utilisateurConnecteDto.setMotDePasse( utilisateurConnecte.getMotDePasse() );
        utilisateurConnecteDto.setDateCreation( utilisateurConnecte.getDateCreation() );
        List<DemandeLocation> list = utilisateurConnecte.getDemandeLocations();
        if ( list != null ) {
            utilisateurConnecteDto.setDemandeLocations( new ArrayList<DemandeLocation>( list ) );
        }
        List<Commentaire> list1 = utilisateurConnecte.getCommentaires();
        if ( list1 != null ) {
            utilisateurConnecteDto.setCommentaires( new ArrayList<Commentaire>( list1 ) );
        }
        List<Topos> list2 = utilisateurConnecte.getTopos();
        if ( list2 != null ) {
            utilisateurConnecteDto.setTopos( new ArrayList<Topos>( list2 ) );
        }
        List<Role> list3 = utilisateurConnecte.getRoles();
        if ( list3 != null ) {
            utilisateurConnecteDto.setRoles( new ArrayList<Role>( list3 ) );
        }

        return utilisateurConnecteDto;
    }
}
