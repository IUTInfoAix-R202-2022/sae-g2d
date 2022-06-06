DROP TABLE IF EXISTS typologie;

CREATE TABLE typologie
(
    NUMERO            INTEGER,
    THEMATIQUE_USAGE  VARCHAR(150),
    DISCIPLINE        VARCHAR(140),
    DEGRE             VARCHAR(130),
    ACADEMIE          VARCHAR(150),
    REGION_ACADEMIQUE VARCHAR(200),
    TYPE_ACTEUR       VARCHAR(200),
    IDENTITE_ACTEUR   VARCHAR(200),
    URL_RESSOURCE     VARCHAR(400),
    NOM_RESSOURCE     VARCHAR(200),
    TYPE_SOURCE       VARCHAR(150),
    COMMENTAIRES      VARCHAR(1500),
    CONSTRAINT pk_numero PRIMARY KEY (NUMERO)
);

INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (1, 'Ludification', 'Toutes disciplines', 'Tous niveaux', 'Academie de Normandie', 'Region academique Normandie',
        'IAN HG Caen, membre du reseau ludus', 'Denis SESTIER', 'http:www.lepetitjournaldesprofs.comreseauludus',
        'Reseau Ludus', 'Blog', 'a dominante HG mais ouvert sur les autres disciplines');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (2, 'Ludification', 'Histoire-geographie', 'Second degre', 'Academie de Clermont-Ferrand',
        'Region academique Auvergne-Rhene-Alpes', 'Charge de mission DANE', 'William BROU',
        'https:www.youtube.comchannelUCRThjUeXnxL_BKUhqJv5XBg', 'Histoire en jeux', 'Chaene YouTube',
        'Charge de mission aupres de la DANE autour des questions de?ludicisation?de l''enseignement, et des usages de la realite augmentee et de la realite virtuelle.?e');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (3, 'Ludification', 'Histoire-geographie', 'Second degre', 'Academie de Creteil',
        'Region academique ile-de-France', 'Enseignant chercheur', 'Romain VINCENT', 'http:jeuvideohistoire.com',
        'Jeu video et histoire', 'Blog',
        'Enseignant en histoire-geographie, doctorant en sciences de l''education, chercheur associe e la BnF');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (4, 'Ludification', 'Histoire-geographie', 'Second degre', 'Academie de Toulouse', 'Region academique Occitanie',
        'Groupe de travail de lAcademie de Toulouse (IAN + IA-IPR)', 'Perrine GOURIO',
        'https:disciplines.ac-toulouse.frhgemctravailler-avec-les-series-americans-et-space-force-pour-etudier-les-fondements-et-les',
        'Enseigner avec les series TV', 'Scenarios pedagogiques', 'Perinne Gourio est IAN HG de l''academie');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (5, 'Ludification', 'Physique-chimie', 'Second degre', 'Academie de Nancy-Metz', 'Region academique Grand Est',
        'IAN Nancy-Metz', 'Florence DENEUVE', 'http:www4.ac-nancy-metz.frphysiquepeda_inversee.php#game',
        'Gamifier la classe', 'Jeux numeriques',
        'e la suite des TraAM, publication par l''academie de 31 jeux (pratique importante dans l''academie)');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (6, 'Ludification', 'Toutes disciplines', 'Tous niveaux', 'Academie de Normandie', 'Region academique Normandie',
        'Collectif d''enseignants', 'Christelle QUENE', 'https:www.cquesne-escapegame.com',
        'Collectif Escape n'' Games', 'Escape games',
        'Collectif d''enseignants sur les escape games pedagogiques et les jeux numeriques');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (7, 'Ludification', 'Toutes disciplines', 'Tous niveaux', 'Academie de Creteil',
        'Region academique ile-de-France', 'Collectif d''enseignants', 'Patrice NADAM  Melanie FENAERT',
        'https:scape.enepe.fr', 'Collectif Secape', 'Escape games',
        'Lieu de partage deescape games pedagogiques coneus par des enseignants, formateurs et mediateurs');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (8, 'Ludification', 'Documentation', 'Second degre', 'Academie de Dijon',
        'Region academique Bourgogne-Franche-Comte', 'Enseignants de l''academie', 'Non precise',
        'http:cdi.ac-dijon.frspip.php?rubrique56', 'Escape games en EMI', 'Jeux numeriques',
        'Page qui regroupe des liens  vers une dizaine de jeux.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (9, 'Ludification', 'Economie et gestion', 'Second degre', 'Academie de Normandie',
        'Region academique Normandie', 'Pele de competences en ecogest', 'Voir Commentaires',
        'http:eco-gestion.spip.ac-rouen.fr?-Jeux-d-evasion-Escape-games-',
        '4 exemples de jeux pedagogiques en economie et gestion', 'Jeux numeriques',
        'Page de presentation du pele de competences http:eco-gestion.spip.ac-rouen.fr?Le-pole-de-competences-Economie-Gestion');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (10, 'Ludification', 'Langues vivantes', 'Second degre', 'Academie de Lille',
        'Region academique Hauts-de-France', 'Professeur d''anglais en lycee', 'Sebastien FRANC',
        'http:interlangues.discipline.ac-lille.fractu-interlanguesflanders-lane-2',
        'Flanders Lane, creation deune ville virtuelle', 'Projet de simulation globale',
        'Article sur le projet dans VNI : https:www.vousnousils.fr20151026classe-inversee-tache-complexe-anglais-577593');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (11, 'Ludification', 'Langues vivantes', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'Professeur d''anglais', 'Charlie ROLLO', 'https:itsenglishoclock.com',
        'It''s English o''Clock', 'Site Perso', 'e voir en particulier : roue des rituels et jeux');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (12, 'Ludification', 'Langues vivantes', 'Second degre', 'Academie de Nice',
        'Region academique Provence-Alpes-Cete d''Azur', 'Groupe TraAM', 'Brigitte CARRERE',
        'https:www.pedagogie.ac-nice.frportail-de-languesindex.phpressources-interlanguestraam',
        'Defis Academique Langues Inter-etablissements', 'Jeux numeriques',
        'Brigitte CARRERE est l''IA-IPR qui a coordonne le projet');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (13, 'Ludification', 'Mathematiques', 'Second degre', 'Academie de Dijon',
        'Region academique Bourgogne-Franche-Comte', 'Professeur de maths', 'Christophe AUCLAIR',
        'http:mathematiques.ac-dijon.frspip.php?article196', 'Applications Academiques', 'Applications',
        'Ensemble deapplications developpees par un enseignant, disponibles dans tous les stores (tablettes et ordi). Tres prisee de la communaute des profs de maths. Gratuit.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (14, 'Ludification', 'Mathematiques', 'Second degre', 'Academie de Creteil', 'Region academique ile-de-France',
        'Groupe de reflexion academique autour du jeu', 'Nicolas LEMOINE  Cyril MICHAUD',
        'http:maths.ac-creteil.frspip.php?article231', 'Brochure "Mathematiques revisites au cycle 4"', 'Brochure',
        'Brochure presentant les travaux deun groupe de reflexion academique autour du jeu.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (15, 'Ludification', 'Mathematiques', 'Tous niveaux', 'Academie de Bordeaux',
        'Region academique Bourgogne-Franche-Comte', 'Professeur de maths au college', 'eric TROUILLOT',
        'https:blog.mathador.freric-trouillot', 'Mathador', 'Jeu numerique',
        'Jeu connu pour travailler le calcul mental');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (16, 'Programmation  codage', 'Physique-chimie', 'Second degre', 'Academie de Lyon',
        'Region academique Auvergne-Rhene-Alpes', 'Groupe GT TraAM et IAN', 'Sarah ROQUES',
        'https:physique-chimie.enseigne.ac-lyon.frspipspip.php?rubrique418',
        'Ensemble des ressources deseTravauxeAcademiqueseMutualises produits par le groupe GTICE', 'Divers',
        'A produit de nombreuses activites tres differentes pendant les TRAAM sur la partie programmation, de nombreuses utilisations dans de nombreux domaines differents et en utilisant differents langages.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (17, 'Programmation  codage', 'Physique-chimie', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'Groupe TraAM', 'Non precise',
        'https:phychim.ac-versailles.frspip.php?article1069', 'Initiation au langage Python', 'Tutoriels',
        'Production de tutoriels video pour la prise en main de Python');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (18, 'Programmation  codage', 'Physique-chimie', 'Second degre', 'Academie de Paris',
        'Region academique ile-de-France', 'Formateurs groupe lycee', 'Non precise',
        'https:www.ac-paris.frportailjcmsp1_1885031formation-groupe-lycee-mars-avril-2019-prise-en-main-du-langage-python?cid=p1_106394&portal=piapp1_59010',
        'Prise en main du langage Python', 'Support de formation', 'Kit de survie Python avec de nombreuses activites');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (19, 'Programmation  codage', 'Toutes disciplines', 'Tous niveaux', 'Academie de Creteil',
        'Region academique ile-de-France', 'Dane Creteil', 'Non precise', 'https:dane.ac-creteil.fr?article781',
        'Operation 10001 codeurs', 'Defi codage',
        'Avec des ressources sur le code en complement e https:dane.ac-creteil.frdefi#appaccueil');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (20, 'Programmation  codage', 'Mathematiques', 'Second degre', 'Plusieurs academies', NULL, 'TraAM',
        'Plusieurs academies', 'https:view.genial.ly5a37c924aa1a1a0e0cf220dd',
        'Synthese TraAM 2017-2018 : "Continuite des apprentissages en algorithmique et programmation"',
        'Synthese TraAM', 'Academies impliquees : Rennes, Nantes, Orleans-Tours, Poitiers et Toulouse');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (21, 'Ludification', 'SES', 'Second degre', 'Academie de Normandie', 'Region academique Normandie',
        'Groupe TraAM', 'Non precise', 'http:ses.spip.ac-rouen.frIMGpdfsynthese.pdf',
        'Des e escape games e en ligne pour stimuler la curiosite des eleves et favoriser les apprentissages en classe de Seconde',
        'Escape games', 'En complement, bilan des TraAM : https:view.genial.ly5ebe55008e243b0d5a32be9d');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (22, 'Enseigner à distance', 'Physique-chimie', 'Second degre', 'Academie de Grenoble',
        'Region academique Auvergne-Rhene-Alpes', 'IAN PC Grenoble', 'Remy BESSET',
        'http:www.ac-grenoble.frdisciplinesspcarticles.php?lng=fr&pg=133',
        'Continuite pedagogique -eQuelques ressources', 'Scenarios pedagogiques',
        'Travail de qualite sur leutilisation des ENT specifiques e la discipline et de nombreuses activites proposees en hybride. Remy Besset IAN de lAcademie enseigne au college et peut repondre e de nombreuses questions sur leutilisation des ENT en hybride');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (23, 'Enseigner à distance', 'Histoire-geographie', 'Second degre', 'Academie de Clermont-Ferrand',
        'Region academique Auvergne-Rhene-Alpes', 'Groupe de travail de lAcademie de Clermont (IAN + IA-IPR)',
        'Anne-Sophie MAHIDDINE', 'http:www.ac-clermont.frdisciplinesindex.php?id=13700',
        'Continuite pedagogique et hybridation', 'Point didactique et scenarios pedagogiques', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (24, 'Enseigner à distance', 'Histoire-geographie', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'GEP HG Versailles', 'Julian OGUER',
        'https:histoire.ac-versailles.frspip.php?rubrique320', 'Propositions de sequences 100% a distance',
        'Scenarios pedagogiques',
        'Julian OGUER est le IAN de l''academie, referent du GEP qui a produit de nombreuses seances 100% a distance');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (25, 'Enseigner à distance', 'Toutes disciplines', 'Tous niveaux', 'Academie de Paris',
        'Region academique ile-de-France', 'Dane Paris', 'Non precise',
        'https:www.ac-paris.frportailjcmsp2_2043013enseignement-a-distance-avec-le-numerique-modele-sap-d',
        'Enseignement a distance avec le numerique | modele SAP@D', 'Point methodologique', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (26, 'Enseigner à distance', 'Documentation', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'GEP documentation Versailles',
        'Anne-Lise DUPONT  Caroline JAN  Daniela BRUN', 'https:documentation.ac-versailles.frspip.php?article567',
        'Le CDI Hors les murs en 2020', 'Bilan du GEP', 'Bilan du GEP documentation 2019-2020');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (27, 'Enseigner à distance', 'Toutes disciplines', 'Tous niveaux', 'Academie de Nancy-Metz',
        'Region academique Grand Est', 'Dane Nancy-Metz', 'Non precise',
        'https:dane.ac-nancy-metz.frtutoriels-video-brne', '120 tutoriels videos BRNE', 'Tutoriels',
        'Tutoriels videos pour utiliser les BRNE Banques de Ressources Numeriques, ecole, college et lycee avec des niveaux de maetrise');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (28, 'Enseigner à distance', 'SVT', 'Second degre', 'Academie de Versailles', 'Region academique ile-de-France',
        'Non precise', 'Bruno BOUCHER  Laurent GUERRE  Melanie FENAERT',
        'https:svt.ac-versailles.frspip.php?article1130', 'Mettre en euvre un enseignement hybride en SVT',
        'Point didactique', 'Article du site adademique disciplinaire SVT');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (29, 'S''exercer  s''entrainer', 'Langues vivantes', 'Second degre', 'Academie de Normandie',
        'Region academique Normandie', 'IAN LV Rouen', 'Laurence HAQUET',
        'http:anglais.spip.ac-rouen.frspip.php?article665',
        'Mettre e disposition des eleves des ressources et leur en faire creer  grece e Glide',
        'Turotiel et scenarios pedagogiques', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (30, 'Realite virtuelle', 'Histoire-geographie', 'Tous niveaux', 'Academie de Toulouse',
        'Region academique Occitanie', 'Groupe de travail GeoImages', 'Non precise', 'https:geoimage.cnes.frfr',
        'Enseigner avec les images satellites', 'Scenarios pedagogiques',
        'Groupe de travail Geoimage (partenariat Education nationale CNES), du 1er degre e la classe preparatoire');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (31, 'Realite virtuelle', 'Toutes disciplines', 'Tous niveaux', 'Academie de Normandie',
        'Region academique Normandie', 'Fondateur de l''application', 'Marc-Aurelien CHARDINE', 'http:mirage.ticedu.fr',
        'Mirage Make - Realite augmentee', 'Application', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (32, 'Realite virtuelle', 'SVT', 'Second degre', 'Academie de Nice',
        'Region academique Provence-Alpes-Cete d''Azur', 'Professeur de SVT', 'Philippe COSENTINO',
        'https:www.pedagogie.ac-nice.frsvtproductionstectoglob3d', 'Tectoglob3D', 'Application',
        'Tectoglob3D est un logiciel de type eglobe virtuele, qui propose de reunir leensemble des fonctionnalites utiles dans leenseignement de la geologie au college et au lycee.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (33, 'Realite virtuelle', 'SVT', 'Second degre', 'Academie de Lille', 'Region academique Hauts-de-France',
        'Groupe TraAM', 'Non precise',
        'http:svt.discipline.ac-lille.frressourcestraamsrealite-augmentee-en-sciences-experimentalesmettre-en-oeuvre-la-realite-virtuelle-et-augmentee-en-classe',
        'Mettre en oeuvre la realite virtuelle et augmentee en classe', 'Scenario pedagogique', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (34, 'Realite virtuelle', 'SVT', 'Second degre', 'Academie de Montpellier', 'Region academique Occitanie',
        'Groupe de professeurs de SVT de l''academie', 'Ludovic DELORME', 'https:lithotheque.ac-montpellier.frgeoduc',
        'La lithotheque', 'Site Internet',
        'Le sitee"Lithotheque Languedoc-Roussillon", de lAcademie de Montpellier, met e disposition deun large public des descriptions de sites geologiques regionaux remarquables.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (35, 'Realite virtuelle', 'SVT', 'Second degre', 'Academie de Creteil', 'Region academique ile-de-France',
        'Groupe TraAM', 'Non precise',
        'http:svt.ac-creteil.fr?Apports-de-la-Realite-virtuelle-et-de-la-Realite-Augmentee-en-SVT-au-college',
        'Apports de la Realite virtuelle et de la Realite Augmentee en SVT, au college', 'Scenarios pedagogiques',
        'En complement synthese des TraAM et notamment le theme 2 "integration de la realite augmentee et de la realite virtuelle en sciences experimentales" https:view.genial.ly5c8f5f6b6f346c7226375a22');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (36, 'Programmation  codage', 'SVT', 'Second degre', NULL, NULL, 'TraAM', 'Non precise',
        'https:view.genial.ly5c8f5f6b6f346c7226375a22', 'Theme 1 : algorithmique et codage en SVT',
        'Scenarios pedagogiques',
        'Academies impliquees : Lille, Strasbourg, Limoges, Montpellier, Aix-Marseille et Nice');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (37, 'Differenciation', 'Histoire-geographie', 'Second degre', 'Academie de Clermont-Ferrand',
        'Region academique Auvergne-Rhene-Alpes', 'IAN et pele de competences numeriques', 'Anne-Sophie MAHIDDINE',
        'http:www.ac-clermont.frdisciplinesindex.php?id=11069', 'Differenciation',
        'Ressources et nombreux scenarios pedagogiques', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (38, 'Ecole inclusive', 'Toutes disciplines', 'Tous niveaux', 'Academie de Normandie',
        'Region academique Normandie', 'Fondateur de l''application', 'Marc-Aurelien CHARDINE',
        'https:miragedys.ticedu.frpage.html', 'Mirage DYS', 'Application',
        'L''application propose une lecture e haute voix du texte, un suivi synchronise des phrases et une lecture mot e mot, avec des vitesses de lecture reglables et des contrastes varies.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (39, 'Ecole inclusive', 'Toutes disciplines', 'Tous niveaux', 'Hors academies', NULL, 'Association',
        'Cartable fantastique', 'https:www.cartablefantastique.fr', 'Association cartable fantastique', 'Site Internet',
        'Le Cartable Fantastique a pour objet eleaide e leinclusion scolaire deenfants en situation de handicap, et en particulier, deenfants dyspraxiquese');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (40, 'Differenciation', 'SVT', 'Second degre', 'Plusieurs academies', NULL, 'TraAM', 'Plusieurs academies',
        'https:eduscol.education.frsvtenseignerressources-et-usages-numeriquestravaux-academiques-mutualises-traamtraam-2017-2018.html#c9681',
        'Les outils pour une differenciation pedagogique efficace', 'Synthese TraAM',
        'Academies impliquees : Toulouse, Amiens, Paris et Clermont-Ferrand');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (41, 'Ecole inclusive', 'Toutes disciplines', 'Tous niveaux', 'Hors academies', NULL, 'Organisme public',
        'Institut National Superieur de Formation et de Recherche pour l''Education des Jeunes Handicapes et les Enseignements Adapte',
        'https:www.inshea.frfrressourceliste-des-fiches-sdadv-multi-filtre',
        'Documents adaptes pour deficients visuels', 'Site Internet', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (42, 'Ecole inclusive', 'Histoire-geographie', 'Second degre', 'Plusieurs academies', NULL,
        'Professeure d''histoire-geographie', 'Benedicte TRATNJEK',
        'https:enseigner-la-geographie.jimdofree.com20200914faire-r%C3%A9investir-le-vocabulaire-de-la-g%C3%A9ographie-scolaire-aux-%C3%A9l%C3%A8ves-allophones',
        'Travailler le vocabulaire de la geographie avec des eleves allophones.', 'Blog', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (43, 'Ecole inclusive', 'Histoire-geographie', 'Second degre', 'Academie de Normandie',
        'Region academique Normandie', 'Enseignants de l''academie', 'Non precise',
        'http:hist-geo.spip.ac-rouen.frspip.php?rubrique565',
        'Adapter son enseignement aux eleves e besoins particuliers', 'Scenarios pedagogiques', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (44, 'Reseaux sociaux', 'Toutes disciplines', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'Academie et CLEMI Versailles', 'Non precise',
        'http:www.education-aux-medias.ac-versailles.fr',
        'Portail de l''education aux medias de l''academie de Versailles', 'Portail de ressources',
        'Voir notamment la rubrique "nouveaux fotmats"');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (45, 'Reseaux sociaux', 'Toutes disciplines', 'Tous niveaux', 'Academie de Nancy-Metz',
        'Region academique Grand Est', 'Dane Nancy-Metz', 'Groupe academique interdegre',
        'https:dane.ac-nancy-metz.freducation-au-numerique', 'Education au numerique : #aucalmesurleweb',
        'Ressources et nombreux scenarios pedagogiques', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (46, 'Reseaux sociaux', 'Langues vivantes', 'Second degre', 'Academie de Creteil',
        'Region academique ile-de-France', 'Professeures deespagnol de lAcademie de Creteil.',
        'Sabine KITTEN  Celine CORTeS  Imma IBANEZ', 'https:dane.ac-creteil.frspip.php?page=article&id_article=751',
        'Le dispositif Twictado', 'Article de presentation du dispositif',
        'Declinaison en espagnol du dispositif Twictee');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (47, 'Reseaux sociaux', 'Langues vivantes', 'Second degre', 'Hors academies', NULL,
        'Professeurs de LVE du cycle 3 au cycle terminal.', 'Collectif de professeurs sur Twitter .',
        'https:twictlingua.wordpress.comhome', '@TwictLingua', 'Site internet du collectif',
        'Le point de convergence est leutilisation de Twitter avec des comptes classes securisees afin de developper e la fois leinteraction ecrite et la mediation, que ce soit en interlangues ou dans la meme langue etrangere.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (48, 'Formation aux outils numeriques en distanciel', 'Physique-chimie', 'Second degre',
        'Academie de Clermont-Ferrand', 'Region academique Auvergne-Rhene-Alpes',
        'IA-IPR referente et le pele de competences de physique-chimie',
        'Delphine PALLIER  Christine BIDEUX  Pierre MARTY',
        'http:www.ac-clermont.fractualitespoc-physique-chimie-et-numerique-2020-06-12?tx_ttnews%5BbackPid%5D=3200',
        'SPOC physique-chimie et numerique', 'Cours en ligne',
        'Les professeurs de physique-chimie de lAcademie se sont vu proposer de developper leur maitrise des usages pedagogiques du numerique pour la realisation d''experiences scientifiques avec smartphone en classe et l''evaluation avec leoutil numerique.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (49, 'Formation aux outils numeriques en distanciel', 'Philosophie', 'Second degre', 'Academie de Toulouse',
        'Region academique Occitanie', 'Professeurs de philosophie de l''academie de Toulouse',
        '3 professeurs de l''academie',
        'https:disciplines.ac-toulouse.frphilosophienumeriquephilonum-base-de-donnees-collaborative-d-outils-numeriques-et-de-retours-d-experience-de',
        'PhiloNum', 'Base de donnees',
        'Base de donnees collaborative qui recense et classe les outils numeriques queutilisent les professeurs de philosophie selon leurs interets pedagogiques.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (50, 'Formation aux outils numeriques en distanciel', 'Philosophie', 'Second degre', 'Academie de Poitiers',
        'Region academique Nouvelle-Aquitaine', 'IAN philosophie de l''academie', 'Franeois eLIE',
        'https:philo-labo.fraccueil', 'Philo-Labo', 'Site internet de partage de pratiques numeriques.',
        'Philo-labo.fr est un lieu de partage de ressources et d''outils');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (51, 'Formation aux outils numeriques en distanciel', 'Langues vivantes', 'Second degre',
        'Academie de Montpellier', 'Region academique Occitanie', 'Professeur de LV', 'Nicolas GAUBE',
        'https:linktr.eea_happy_teacher_true_story', '@a_happy_teacher_true_story',
        'Site d''un collegue de LV qui propose de nombreux tutoriels', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (52, 'Formation aux outils numeriques en distanciel', 'Histoire-geographie', 'Second degre',
        'Academie de Poitiers', 'Region academique Nouvelle-Aquitaine', 'Professeur d''HG', 'Johann NALLET',
        'https:www.youtube.comchannelUC8pCnomr8VIuW8x6wHXsYxAvideos', 'Johann NALLET (Chaene YouTube)',
        'Chaene Youtube', 'Nombreux tutoriels tres bien faits et qui peuvent servir e d''autres disciplines.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (53, 'Webradio', 'Toutes disciplines', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'Academie et CLEMI Versailles',
        'http:www.education-aux-medias.ac-versailles.frspip.php?page=mentions',
        'http:www.education-aux-medias.ac-versailles.fr',
        'Portail de l''education aux medias de l''academie de Versailles', 'Portail de ressources',
        'Voir notamment les rubriques "WebTV WebRadio"');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (54, 'Webradio', 'Histoire-geographie', 'Second degre', 'Academie de Versailles',
        'Region academique ile-de-France', 'GEP HG Versailles', 'Frank FONSA',
        'https:histoire.ac-versailles.frspip.php?rubrique284', 'Festival des webradios scolaires', 'Festival',
        'Ce festival organise depuis plusieurs annees propose deerealiser une emission de radio consacree e une thematique ancree dans leactualite et liee e lehistoire, la geographie ou leenseignement moral et civique.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (55, 'Webradio', 'Histoire-geographie', 'Second degre', 'Academie d''Orleans-Tours',
        'Region academique Centre-Val de Loire', 'Enseignants HG de l''academie', 'Eric FARDEL',
        'https:www.ac-orleans-tours.frpedagogiehg_ecenseignerenseigner_autrementwebradio_des_rendez_vous_de_lhistoire_a_blois',
        'Webradio des Rendez-vous de l''Histoire e Blois', 'Webradio',
        'Depuis 2010, e l''occasion des Rendez-vous de l''Histoire de Blois, des enseignants de l''academie preparent avec leurs eleves une emission consacree au theme du festival, en lien avec les programmes.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (56, 'Evaluation', 'SES', 'Second degre', 'Plusieurs academies', NULL, 'TraAM', 'Plusieurs academies',
        'https:eduscol.education.frsesanimationaamtraam-2018-2019traam-2018-2019-bilan',
        'Le numerique au service de levaluation des apprentissages des eleves', 'Synthese TraAM',
        'Academies impliquees : Paris, Reims, Strasbourg, Orleans-Tours');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (57, 'Formation aux outils numeriques en distanciel', 'Toutes disciplines', 'Tous niveaux', 'Hors academies',
        NULL, 'Groupe de professeurs', 'Jeff SIMON  Guillaume OGIER  Sebastien DURIETZ  Sebastien MANODRITTA',
        'http:e-teachers.fr', 'E-teachers', 'Podcast',
        'E-teachers est une emission bi-mensuelle diffusee en podcast Audio et Video qui parle education, numerique, innovation et experimentation');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (58, 'Travail entre pairs', 'Langues vivantes', 'Second degre', 'Academie de Dijon',
        'Region academique Bourgogne-Franche-Comte', 'Presidente du colloque', 'Cathia GAITA-KINACI',
        'Site en construction', 'Colloque Interstices', 'Colloque', 'practicelangues@gmail.com');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (59, 'Travail entre pairs', 'Toutes disciplines', 'Tous niveaux', 'Hors academies', NULL,
        'Collectif d''enseignants du premier degre, du second degre (college, lycee general, technologique, lycee professionnel, chercheurs',
        'https:patchworkfr.coma-propos', 'https:patchworkfr.comptchwork', 'P@tChwerK', 'Collectif d''enseignants',
        'Espace de partages, dechanges pedagogiques sur des sujets divers comme la memorisation, le droit e leerreur, le bien-etre, la ludification, les competences du XXIe siecle. Compte Twitter : @PtChwrKFR');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (60, 'Reseaux sociaux', 'Mathematiques', 'Tous niveaux', 'Hors academies', NULL, 'Association',
        'Carole CORTAY  Christophe GILGER', 'https:www.mathsenvie.fr', 'M@ath en_vie', 'Association',
        'L''association propose regulierement des defis via les reseaux sociaux avec notamment (5 comptes Twitter: cycle1, cycle2, cycle3, cycle4 et lycee)');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (61, 'Travail entre pairs', NULL, 'Tous niveaux', 'Hors academies', NULL,
        'Association EMC Partageons -Collectif d''enseignants volontaires',
        'https:www.emcpartageons.orgconseil-dadministration', 'https:www.emcpartageons.org', 'EMC, partageons !', NULL,
        'Dispositif inclusif, interactif, collaboratif et formatif en Enseignement Moral et Civique (EMC), cre par des enseignants pour des enseignants. Compte Twitter : @EMCpartageons');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (62, 'Ludification', 'Biotechnologies-STMS', 'Second degre', 'Academie d''Aix-Marseille',
        'Region academique Provence-Alpes-Cete d''Azur', 'Groupe TraAM', 'Non precise',
        'ehttps:www.pedagogie.ac-aix-marseille.frjcmsc_10880672frludification-les-traam-de-l-academie-d-aix-marseille-st2s-biotechnologies-et-lpro',
        'Ludification : les TraAM de l''academie d''Aix-Marseille', 'Scenarios pedagogiques',
        'Page qui regroupe plusieurs scenarios sur des jeux serieux');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (63, 'Classe inversee', 'Biotechnologies-STMS', 'Second degre', 'Academie d''Aix-Marseille',
        'Region academique Provence-Alpes-Cete d''Azur', 'Groupe TraAM', 'Non precise',
        'https:www.pedagogie.ac-aix-marseille.frjcmsc_10880668frpedagogie-actives-et-differenciees-les-traams-academiques',
        'Pedagogie active et differenciee', 'Scenarios pedagogiques',
        'Page qui recense plusieurs scenarios de classe inversee');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (64, 'Classe inversee', 'Biotechnologies-STMS', 'Second degre', 'Academie de Poitiers',
        'Region academique Nouvelle-Aquitaine', 'Groupe TraAM', 'Non precise',
        'http:ww2.ac-poitiers.frbiochimiespip.php?article409', 'TraAM pedagogie active et differenciee',
        'Scenarios pedagogiques', 'Page qui recense plusieurs scenarios de classe inversee');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (65, 'Travail entre pairs', 'Toutes disciplines', 'Second degre', 'Academie de Rennes',
        'Region academique Bretagne', 'Rectorat et professeurs', 'https:www.interactik.frportailwebequipe-interactik',
        'https:www.interactik.frportailweb', 'Interactik', 'Cooperative pedagogique numerique',
        'Site pour favoriser le partage et le travail collaboratif entre enseignants pour se former et produire des ressources en cooperant.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (66, 'Reseaux sociaux', 'Lettres', 'Tous niveaux', 'Hors academies', NULL,
        'Dispositif collaboratif d''enseignants', 'Non precise', 'https:www.twictee.orgtwictee', 'Twictee',
        'Site Internet de l''association',
        'Dispositif pedagogique collaboratif centre sur leenseignement et leapprentissage de leorthographe. Met en relation des classes francophones qui echangent de courtes dictees et des regles de correction produites par les eleves, grece e leutilisation de Twitter.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (67, 'Reseaux sociaux', 'Toutes disciplines', 'Premier degre', 'Hors academies', NULL, 'Enseignants',
        'elodie BONNEFOY-CUDRAZ  Arnaud EYMERY  Matthieu ROLLIN',
        'https:view.genial.ly5e531be12049210fb2c0e8fdpresentation-quotichess-synthese', 'Quotichess', 'Site internet',
        'Parties d''echecs entre classes via le reseau social Twitter');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (68, 'Reseaux sociaux', 'Lettres', 'Tous niveaux', 'Hors academies', NULL, 'Enseignants',
        'https:twittenrimes.coma-propos-2', 'https:twittenrimes.com', 'TwittenRimes', NULL,
        'Projet collaborarif autour de la poesie');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (69, 'Enseigner à distance', 'Arts plastiques', 'Second degre', 'Academie de Montpellier',
        'Region academique Occitanie', 'Professeurs Arts plastiques', 'Nombreux auteurs',
        'https:pedagogie.ac-montpellier.frpropositions-pedagogiques-en-arts-plastiques-pendant-le-confinement-2020',
        'Propositions pedagogiques en arts plastiques pendant le confinement 2020', 'Scenarios pedagogiques', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (70, 'Enseigner à distance', 'Arts plastiques', 'Second degre', 'Academie d''Orleans-Tours',
        'Region academique Centre-Val de Loire', 'Professeurs Arts plastiques', 'Nombreux auteurs',
        'https:www.ac-orleans-tours.frpedagogiearts_plastiquesressourcesenseignement_a_distancepropositions_et_mise_en_partage_de_sequences',
        'Propositions et mise en partage de sequences', 'Scenarios pedagogiques',
        'Ressources enseignement a distance : Propositions academiques de pistes, fiches, sequences, concours, defis.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (71, 'Formation aux outils numeriques en distanciel', 'Arts plastiques', 'Second degre', 'Academie d''Amiens',
        'Region academique Hauts-de-France', 'Groupe de recherche numerique en arts plastiques',
        'Clement CHERVIER   Gautier DIRSON  Thomas FAUQUEMBERGUE  Cecile HARLEAUX  Nicolas HOTIN  Jacques M ARCEL  Franeois QUILLARD',
        'https:view.genial.ly5c3f2a07a4eaa03097dcca2c', 'Arts plastiques et expressions numeriques',
        'References croisant arts plastiques et numerique avec une structuration basee sur des couples de notions en articulation avec des problematiques.',
        'Comment penser les arts plastiques au regard des expressions numeriques ?');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (72, 'Formation aux outils numeriques en distanciel', 'Lettres', 'Second degre', 'Academie de Paris',
        'Region academique ile-de-France', 'CASNAV',
        'Julien FUMEY  Gaelle ANDReE MOROIS  Cecile MASSARD  Alice le BIHAN',
        'https:www.ac-paris.frportailjcmsp2_2298853le-numerique-en-fls-bilans-perspectives-ouverture-d-un-magistere',
        'Le numerique en FLS : bilans, perspectives', 'Parcours M@gistere', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (73, 'Differenciation', 'Toutes disciplines', 'Tous niveaux', 'Academie de Poitiers',
        'Region academique ile-de-France', 'Projet academique', 'Sous impulsion du recteur Gilles PeCOUT',
        'https:www.ac-paris.frportailjcmsp2_1877871accueil', 'Observatoire de la differenciation pedagogique.',
        'Site Internet', NULL);
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (74, 'Travail entre pairs', 'Lettres', 'Second degre', 'Academie de Normandie', 'Region academique Normandie',
        '3 IAN lettres', 'Gregory DEVIN  Cyril MISTRORIGO  Lionel VIGUIER',
        'https:lettres-modernes.discip.ac-caen.frspip.php?article773', 'Le Reseau des Lettres',
        'Site internet avec travaux d''eleves et ressources pedagogiques',
        'Projet pour renouveler les pratiques de lecture et les modalites de reception des euvres par dele les murs de la classe et les frontieres academiques.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (75, 'Travail entre pairs', 'EPS', 'Second degre', 'Academie de Montpellier', 'Region academique Occitanie',
        'Professeurs d''EPS', 'Franeois FONTANY  Yannick DARTOIS', 'http:epsbox.free.fr#page-content',
        'Creation et programmation avec Raspberry Pi => EPSBOX', 'Site Internet',
        'La boite e ressources numeriques pour l''EPS');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (76, 'Travail entre pairs', 'EPS', 'Second degre', 'Hors academies', NULL, 'Association',
        'https:www.aeeps.orgaeepsqui-sommes-nous.html', 'https:www.aeeps.orgsearch?keyword=numerique',
        'AEEPSe: ressources numeriques', 'Ressources numeriques sur le site internet',
        'Association qui euvre pour le developpement de leEPS');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (77, 'Travail entre pairs', 'EPS', 'Second degre', 'Hors academies', NULL, 'Professeurs d''EPS',
        'Mattieu DEJEAN  Julien TIXIER', 'https:www.tablettesetsurvetements.fr', 'Tablettes&survetements',
        'Site internet', 'Traits d''unions entre education physique et numerique, par des profs, pour des profs');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (78, 'Differenciation', 'EPS', 'Second degre', 'Academie de Versailles', 'Region academique ile-de-France',
        'Professeurs d''EPS', 'Non precise', 'https:eps.ac-versailles.frspip.php?article138', 'EPSilon',
        'Application EPS', 'Application EPS Versailles pour creer des parcours');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (79, 'Ludification', 'Biotechnologies-STMS', 'Second degre', 'Academie d''Amiens',
        'Region academique Hauts-de-France', 'Groupe TraAM', 'Non precise',
        'http:sante-social.ac-amiens.fr257-ressources-pedagogiques-numeriques.html',
        'Ressource s pedagogiques numeriques', 'Scenarios TraAM', 'Conception de plusieurs jeux serieux');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (80, 'Travail entre pairs', 'Histoire-geographie', 'Second degre', 'Academie de Besaneon',
        'Region academique Bourgogne-Franche-Comte', 'Collectif deenseignants', 'Philippe SALLET',
        'http:hg.ac-besancon.frcategorymoochgb', 'MoocHG', 'Mooc',
        'Mooc organise depuis plusieurs annees par des enseignants pour les enseignants sur les pratiques numeriques');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (81, 'Ludification', 'Toutes disciplines', 'Tous niveaux', 'Hors academies', NULL, 'Association', NULL,
        'http:www.semperludens.fr', 'Team Ludens', 'Site Internet',
        'Collectif deenseignants de toutes  les disciplines autour de la thematique de la ludification');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (82, 'Travail entre pairs', 'Toutes disciplines', 'Second degre', 'Hors academies', NULL,
        'Collectif d''enseignants', 'Compte Twittere: @HispaFormation', 'https:www.hispaformation.com',
        'Hispaformation', 'Site Internet',
        'Association deenseignants formateurs en espagnol, mutualisation et partage de la formation continue.');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (83, 'Formation aux outils numeriques en distanciel', 'Toutes disciplines', 'Tous niveaux', 'Hors academies',
        NULL, 'Enseignant', 'Fidel Navamuel', 'https:outilstice.com', 'Les outils TICE',
        'Site Internet et lettre deinformations', 'Leactualite des outils numeriques pour leducation');
INSERT INTO typologie(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR,
                      IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES)
VALUES (84, 'Formation aux outils numeriques en distanciel', 'Toutes disciplines', 'Tous niveaux', 'Hors academies',
        NULL, 'Enseignant', NULL, 'https:ladigitale.dev', 'La Digitale', 'Applications',
        'Des outils numeriques libres pour les enseignants');