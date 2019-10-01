package com.lade.app.dto.contract;

import com.lade.app.dto.impl.CommentaireDto;
import entities.Commentaire;
import entities.SiteEscalade;
import entities.UtilisateurConnecte;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-01T22:57:31+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class CommentaireMapperImpl implements CommentaireMapper {

    @Override
    public Commentaire toCommentaire(CommentaireDto commentaireDto) {
        if ( commentaireDto == null ) {
            return null;
        }

        Commentaire commentaire = new Commentaire();

        commentaire.setUtilisateurConnecte( commentaireDtoToUtilisateurConnecte( commentaireDto ) );
        commentaire.setSiteEscalade( commentaireDtoToSiteEscalade( commentaireDto ) );
        commentaire.setId( commentaireDto.getId() );
        commentaire.setTitre( commentaireDto.getTitre() );
        commentaire.setMessage( commentaireDto.getMessage() );
        commentaire.setDateCreation( commentaireDto.getDateCreation() );

        return commentaire;
    }

    @Override
    public CommentaireDto toCommentaireDto(Commentaire commentaire) {
        if ( commentaire == null ) {
            return null;
        }

        CommentaireDto commentaireDto = new CommentaireDto();

        commentaireDto.setSiteEscalade( commentaireSiteEscaladeId( commentaire ) );
        commentaireDto.setUtilisateurConnecte( commentaireUtilisateurConnecteUsername( commentaire ) );
        commentaireDto.setId( commentaire.getId() );
        commentaireDto.setTitre( commentaire.getTitre() );
        commentaireDto.setMessage( commentaire.getMessage() );
        commentaireDto.setDateCreation( commentaire.getDateCreation() );

        return commentaireDto;
    }

    protected UtilisateurConnecte commentaireDtoToUtilisateurConnecte(CommentaireDto commentaireDto) {
        if ( commentaireDto == null ) {
            return null;
        }

        UtilisateurConnecte utilisateurConnecte = new UtilisateurConnecte();

        utilisateurConnecte.setUsername( commentaireDto.getUtilisateurConnecte() );

        return utilisateurConnecte;
    }

    protected SiteEscalade commentaireDtoToSiteEscalade(CommentaireDto commentaireDto) {
        if ( commentaireDto == null ) {
            return null;
        }

        SiteEscalade siteEscalade = new SiteEscalade();

        siteEscalade.setId( commentaireDto.getSiteEscalade() );

        return siteEscalade;
    }

    private Long commentaireSiteEscaladeId(Commentaire commentaire) {
        if ( commentaire == null ) {
            return null;
        }
        SiteEscalade siteEscalade = commentaire.getSiteEscalade();
        if ( siteEscalade == null ) {
            return null;
        }
        Long id = siteEscalade.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String commentaireUtilisateurConnecteUsername(Commentaire commentaire) {
        if ( commentaire == null ) {
            return null;
        }
        UtilisateurConnecte utilisateurConnecte = commentaire.getUtilisateurConnecte();
        if ( utilisateurConnecte == null ) {
            return null;
        }
        String username = utilisateurConnecte.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
