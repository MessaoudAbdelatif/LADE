--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: commentaire; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.commentaire (
    id bigint NOT NULL,
    date_edition timestamp without time zone,
    message text,
    titre character varying(255),
    nom_site_escalade bigint,
    nom_emetteur character varying(255)
);


ALTER TABLE public.commentaire OWNER TO admin_db_lade;

--
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO admin_db_lade;

--
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- Name: demande_location; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.demande_location (
    id bigint NOT NULL,
    date_debut timestamp without time zone,
    date_fin timestamp without time zone,
    message character varying(255),
    proprio_validation boolean,
    topos_id bigint,
    utilisateur_id character varying(255)
);


ALTER TABLE public.demande_location OWNER TO admin_db_lade;

--
-- Name: demande_location_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.demande_location_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.demande_location_id_seq OWNER TO admin_db_lade;

--
-- Name: demande_location_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.demande_location_id_seq OWNED BY public.demande_location.id;


--
-- Name: longeur; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.longeur (
    id bigint NOT NULL,
    cotation character varying(255),
    nom character varying(255),
    voie_id bigint
);


ALTER TABLE public.longeur OWNER TO admin_db_lade;

--
-- Name: longeur_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.longeur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.longeur_id_seq OWNER TO admin_db_lade;

--
-- Name: longeur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.longeur_id_seq OWNED BY public.longeur.id;


--
-- Name: role; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.role (
    id integer NOT NULL,
    role character varying(255)
);


ALTER TABLE public.role OWNER TO admin_db_lade;

--
-- Name: secteur; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.secteur (
    id bigint NOT NULL,
    description character varying(255),
    nom character varying(255),
    site_escalade_id bigint
);


ALTER TABLE public.secteur OWNER TO admin_db_lade;

--
-- Name: secteur_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.secteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_id_seq OWNER TO admin_db_lade;

--
-- Name: secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;


--
-- Name: site_escalade; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.site_escalade (
    id bigint NOT NULL,
    lieu character varying(255),
    nombre_secteur integer,
    nom character varying(255),
    tag boolean,
    type_roche character varying(255),
    ville_proximite character varying(255)
);


ALTER TABLE public.site_escalade OWNER TO admin_db_lade;

--
-- Name: site_escalade_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.site_escalade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_escalade_id_seq OWNER TO admin_db_lade;

--
-- Name: site_escalade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.site_escalade_id_seq OWNED BY public.site_escalade.id;


--
-- Name: topos; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.topos (
    id bigint NOT NULL,
    date_de_parution timestamp without time zone,
    description character varying(255),
    disponible_en_location boolean,
    lien character varying(255),
    lieu_de_parution character varying(255),
    loue boolean,
    nom character varying(255),
    utilisateur_id character varying(255)
);


ALTER TABLE public.topos OWNER TO admin_db_lade;

--
-- Name: topos_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.topos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topos_id_seq OWNER TO admin_db_lade;

--
-- Name: topos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.topos_id_seq OWNED BY public.topos.id;


--
-- Name: utilisateur_connecte; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.utilisateur_connecte (
    username character varying(60) NOT NULL,
    civilite character varying(255),
    date_creation timestamp without time zone,
    email character varying(255),
    etat_compte boolean,
    mot_de_pass character varying(255),
    nom character varying(255),
    prenom character varying(255),
    presentation_personel character varying(255)
);


ALTER TABLE public.utilisateur_connecte OWNER TO admin_db_lade;

--
-- Name: utilisateur_connecte_roles; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.utilisateur_connecte_roles (
    username character varying(255) NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.utilisateur_connecte_roles OWNER TO admin_db_lade;

--
-- Name: voie; Type: TABLE; Schema: public; Owner: admin_db_lade
--

CREATE TABLE public.voie (
    id bigint NOT NULL,
    cotation character varying(255),
    descreption character varying(255),
    nom character varying(255),
    secteur_id bigint
);


ALTER TABLE public.voie OWNER TO admin_db_lade;

--
-- Name: voie_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_db_lade
--

CREATE SEQUENCE public.voie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_seq OWNER TO admin_db_lade;

--
-- Name: voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_db_lade
--

ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;


--
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- Name: demande_location id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.demande_location ALTER COLUMN id SET DEFAULT nextval('public.demande_location_id_seq'::regclass);


--
-- Name: longeur id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.longeur ALTER COLUMN id SET DEFAULT nextval('public.longeur_id_seq'::regclass);


--
-- Name: secteur id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.secteur ALTER COLUMN id SET DEFAULT nextval('public.secteur_id_seq'::regclass);


--
-- Name: site_escalade id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.site_escalade ALTER COLUMN id SET DEFAULT nextval('public.site_escalade_id_seq'::regclass);


--
-- Name: topos id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.topos ALTER COLUMN id SET DEFAULT nextval('public.topos_id_seq'::regclass);


--
-- Name: voie id; Type: DEFAULT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.voie ALTER COLUMN id SET DEFAULT nextval('public.voie_id_seq'::regclass);


--
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.commentaire (id, date_edition, message, titre, nom_site_escalade, nom_emetteur) FROM stdin;
12	2019-10-02 18:39:33.886	J'ai adoré le lieu, je recommande viviement !!	Super Spot	1	Ilyes
13	2019-10-03 00:57:07.291	Le petit port du Poussaï est tellement pittoresque que c’est l’endroit qu’ont choisi les 20000 GI’s de la 36e division du Texas pour débarquer le 15août 1944. Ça, c’est pour la visite culturelle en cas de pluie…	J'adore ce site	7	user2
\.


--
-- Data for Name: demande_location; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.demande_location (id, date_debut, date_fin, message, proprio_validation, topos_id, utilisateur_id) FROM stdin;
11	2019-10-03 00:00:00	2019-10-05 00:00:00	J'aimerai bien loué votre topo pour cette durée \r\nMerci.	t	12	admin2
\.


--
-- Data for Name: longeur; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.longeur (id, cotation, nom, voie_id) FROM stdin;
1	3B+	phase 1	1
2	3A+	Première longeur	2
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.role (id, role) FROM stdin;
1	USER
2	ADMIN
\.


--
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.secteur (id, description, nom, site_escalade_id) FROM stdin;
1	wow assez dure	rapid way	1
2	wow	rapid way v2	1
3	test 2	test	1
4	Familiale assez facile, belle vue !	lépic ascension	3
5	secteur façade sud	Les gorges du Blavet	7
6	Pour les grandes voies	Le pic du Perthus	7
7	si vous avez envie de forcer un peu et que vous cherchez du plus dur	Saint-Sauves	8
8	pour des grandes voies dans un décor inoubliable.	La Crête de Coq 	8
9		La Chalp	9
10		La Dalle de Chantelouve	9
11		Les Pinets	9
\.


--
-- Data for Name: site_escalade; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.site_escalade (id, lieu, nombre_secteur, nom, tag, type_roche, ville_proximite) FROM stdin;
2	Isère	0	La vallée de la mort	t	Bazelt	Grenoble
1	Bron	3	La fournaise	t	Granite	LYON
3	Isère	1	La vallée de la mort	t	Bazelt	Grenoble
8	Auvergne	2	Le Capucin	f	Bloc	Clermont-Ferrand
9	Isère	3	Le Rocher de 11 heures	f	Falaise	Grenoble
7	Var	2	Cap Dramont	t	Falaise	Toulon
\.


--
-- Data for Name: topos; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.topos (id, date_de_parution, description, disponible_en_location, lien, lieu_de_parution, loue, nom, utilisateur_id) FROM stdin;
12	2019-10-03 00:25:52.053	Contient l'essentiel des secteurs je vous invite à découvrir	t	http://topo-calanques.com/commande-topo-calanques/	Marseille	\N	Les Calanques	user2
14	2019-10-03 01:23:24.45	Topo escalade :\r\n1/ rocher de la fraîche\r\n2/ Rocher d’isertan\r\n3/ Dalle de la Six	t	http://www.pralognan.com/files/uploads/2017/06/15/Topo%20plan%20escalade.pdf	Savoie	\N	La vanoise	admin2
13	2019-10-03 00:32:58.536	La face sud de Chamechaude (2082 m) est composée de plusieurs piliers rocheux bien visibles de Grenoble.	f	https://planetgrimpe.com/falaise/le-bourrinoire/	Chartreuse	\N	La Chamechaude	user2
\.


--
-- Data for Name: utilisateur_connecte; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.utilisateur_connecte (username, civilite, date_creation, email, etat_compte, mot_de_pass, nom, prenom, presentation_personel) FROM stdin;
user2	MR	2019-09-22 02:37:29.67442	dj_mess@hotmail.fr	t	$2a$10$vmnBz8apEZlzHaPRlAwiRup3C.ab5wU.7yO8ZW6eOqWgJVaelcPRC	ABDELATIF	MESSAOUD	\N
admin2	MR	2019-09-23 10:08:12.325307	dj_mess@hotmail.fr	t	$2a$10$p1jO31CXHV3ikpsiAM7EDex7714eJ5k2IyBKL5jrAJ7EnN43.C0E.	John	Franck	bONJOUR JE SUIS LAAAAAa
Ilyes	MR	2019-10-02 18:35:17.747825	ilyes@hotmail.fr	t	$2a$10$3FyHvs6CKvpiLPlxlMkjLOJzu2.TfG/An0Ml81OOu5Vv/wjQVOCLe	ABDELATIF	Ilyes	je fais bcp de betises
\.


--
-- Data for Name: utilisateur_connecte_roles; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.utilisateur_connecte_roles (username, role_id) FROM stdin;
user2	1
admin2	1
admin2	2
Ilyes	1
\.


--
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: admin_db_lade
--

COPY public.voie (id, cotation, descreption, nom, secteur_id) FROM stdin;
1	3C+	première partie	rapid way v1	1
2	3B	recommander pour l'apprentissage.	Chrono voie rapide	4
3	6B	assez raide	Poussaï	5
\.


--
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 13, true);


--
-- Name: demande_location_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.demande_location_id_seq', 11, true);


--
-- Name: longeur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.longeur_id_seq', 2, true);


--
-- Name: secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.secteur_id_seq', 11, true);


--
-- Name: site_escalade_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.site_escalade_id_seq', 9, true);


--
-- Name: topos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.topos_id_seq', 14, true);


--
-- Name: voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_db_lade
--

SELECT pg_catalog.setval('public.voie_id_seq', 3, true);


--
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- Name: demande_location demande_location_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.demande_location
    ADD CONSTRAINT demande_location_pkey PRIMARY KEY (id);


--
-- Name: longeur longeur_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.longeur
    ADD CONSTRAINT longeur_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: secteur secteur_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pkey PRIMARY KEY (id);


--
-- Name: site_escalade site_escalade_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.site_escalade
    ADD CONSTRAINT site_escalade_pkey PRIMARY KEY (id);


--
-- Name: topos topos_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.topos
    ADD CONSTRAINT topos_pkey PRIMARY KEY (id);


--
-- Name: utilisateur_connecte utilisateur_connecte_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.utilisateur_connecte
    ADD CONSTRAINT utilisateur_connecte_pkey PRIMARY KEY (username);


--
-- Name: voie voie_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pkey PRIMARY KEY (id);


--
-- Name: commentaire fk2e2h481v1hixxhfqslagigkl6; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fk2e2h481v1hixxhfqslagigkl6 FOREIGN KEY (nom_site_escalade) REFERENCES public.site_escalade(id);


--
-- Name: demande_location fk2q322jgnpckl1ioejrlf7t2ab; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.demande_location
    ADD CONSTRAINT fk2q322jgnpckl1ioejrlf7t2ab FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur_connecte(username);


--
-- Name: utilisateur_connecte_roles fk3hp7m6nlygsllepf2tyca0en2; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.utilisateur_connecte_roles
    ADD CONSTRAINT fk3hp7m6nlygsllepf2tyca0en2 FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: secteur fk9u7d8igwu8ya5nk743ofjxumd; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT fk9u7d8igwu8ya5nk743ofjxumd FOREIGN KEY (site_escalade_id) REFERENCES public.site_escalade(id);


--
-- Name: demande_location fkcn9dk0bsj0ng4cnlsx7b9k854; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.demande_location
    ADD CONSTRAINT fkcn9dk0bsj0ng4cnlsx7b9k854 FOREIGN KEY (topos_id) REFERENCES public.topos(id);


--
-- Name: longeur fkes2d3o6gwolxmom7cwhgfu7jf; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.longeur
    ADD CONSTRAINT fkes2d3o6gwolxmom7cwhgfu7jf FOREIGN KEY (voie_id) REFERENCES public.voie(id);


--
-- Name: utilisateur_connecte_roles fkkfvgy5dx3tudtrg23jbyqb9du; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.utilisateur_connecte_roles
    ADD CONSTRAINT fkkfvgy5dx3tudtrg23jbyqb9du FOREIGN KEY (username) REFERENCES public.utilisateur_connecte(username);


--
-- Name: commentaire fkl2ajyrjjx7tlfqe0rs49n1y7w; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fkl2ajyrjjx7tlfqe0rs49n1y7w FOREIGN KEY (nom_emetteur) REFERENCES public.utilisateur_connecte(username);


--
-- Name: topos fkmbijf8ffcn8ajtetryrjvocat; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.topos
    ADD CONSTRAINT fkmbijf8ffcn8ajtetryrjvocat FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur_connecte(username);


--
-- Name: voie fkqlo061c6fgkuosv9chywpgn8t; Type: FK CONSTRAINT; Schema: public; Owner: admin_db_lade
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT fkqlo061c6fgkuosv9chywpgn8t FOREIGN KEY (secteur_id) REFERENCES public.secteur(id);


--
-- PostgreSQL database dump complete
--

