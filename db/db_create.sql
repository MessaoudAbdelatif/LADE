create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to admin_db_lade;

create table role
(
    id   integer not null
        constraint role_pkey
            primary key,
    role varchar(255)
);

alter table role
    owner to admin_db_lade;

create table site_escalade
(
    id              bigserial not null
        constraint site_escalade_pkey
            primary key,
    lieu            varchar(255),
    nombre_secteur  integer,
    nom             varchar(255),
    tag             boolean,
    type_roche      varchar(255),
    ville_proximite varchar(255)
);

alter table site_escalade
    owner to admin_db_lade;

create table secteur
(
    id               bigserial not null
        constraint secteur_pkey
            primary key,
    description      varchar(255),
    nom              varchar(255),
    site_escalade_id bigint
        constraint fk9u7d8igwu8ya5nk743ofjxumd
            references site_escalade
);

alter table secteur
    owner to admin_db_lade;

create table utilisateur_connecte
(
    username              varchar(60) not null
        constraint utilisateur_connecte_pkey
            primary key,
    civilite              varchar(255),
    date_creation         timestamp,
    email                 varchar(255),
    etat_compte           boolean,
    mot_de_pass           varchar(255),
    nom                   varchar(255),
    prenom                varchar(255),
    presentation_personel varchar(255)
);

alter table utilisateur_connecte
    owner to admin_db_lade;

create table commentaire
(
    id                bigserial not null
        constraint commentaire_pkey
            primary key,
    date_edition      timestamp,
    message           text,
    titre             varchar(255),
    nom_site_escalade bigint
        constraint fk2e2h481v1hixxhfqslagigkl6
            references site_escalade,
    nom_emetteur      varchar(255)
        constraint fkl2ajyrjjx7tlfqe0rs49n1y7w
            references utilisateur_connecte
);

alter table commentaire
    owner to admin_db_lade;

create table topos
(
    id                     bigserial not null
        constraint topos_pkey
            primary key,
    date_de_parution       timestamp,
    description            varchar(255),
    disponible_en_location boolean,
    lien                   varchar(255),
    lieu_de_parution       varchar(255),
    loue                   boolean,
    nom                    varchar(255),
    utilisateur_id         varchar(255)
        constraint fkmbijf8ffcn8ajtetryrjvocat
            references utilisateur_connecte
);

alter table topos
    owner to admin_db_lade;

create table demande_location
(
    id                 bigserial not null
        constraint demande_location_pkey
            primary key,
    date_debut         timestamp,
    date_fin           timestamp,
    message            varchar(255),
    proprio_validation boolean,
    topos_id           bigint
        constraint fkcn9dk0bsj0ng4cnlsx7b9k854
            references topos,
    utilisateur_id     varchar(255)
        constraint fk2q322jgnpckl1ioejrlf7t2ab
            references utilisateur_connecte
);

alter table demande_location
    owner to admin_db_lade;

create table utilisateur_connecte_roles
(
    username varchar(255) not null
        constraint fkkfvgy5dx3tudtrg23jbyqb9du
            references utilisateur_connecte,
    role_id  integer      not null
        constraint fk3hp7m6nlygsllepf2tyca0en2
            references role
);

alter table utilisateur_connecte_roles
    owner to admin_db_lade;

create table voie
(
    id          bigserial not null
        constraint voie_pkey
            primary key,
    cotation    varchar(255),
    descreption varchar(255),
    nom         varchar(255),
    secteur_id  bigint
        constraint fkqlo061c6fgkuosv9chywpgn8t
            references secteur
);

alter table voie
    owner to admin_db_lade;

create table longeur
(
    id       bigserial not null
        constraint longeur_pkey
            primary key,
    cotation varchar(255),
    nom      varchar(255),
    voie_id  bigint
        constraint fkes2d3o6gwolxmom7cwhgfu7jf
            references voie
);

alter table longeur
    owner to admin_db_lade;

