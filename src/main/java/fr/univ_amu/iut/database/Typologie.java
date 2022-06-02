package fr.univ_amu.iut.database;

public class Typologie {

    private int numero;

    private String thematique_usage;

    private String discipline;

    private String degre;

    private String academie;

    private String region_academique;

    private String type_acteur;

    private String identite_acteur;

    private String url_ressource;

    private String nom_ressource;

    private String type_source;

    private String commentaires;

    public Typologie(){

    }

    public Typologie(int numero, String thematique_usage, String discipline, String degre, String academie, String region_academique, String type_acteur, String identite_acteur, String url_ressource, String nom_ressource, String type_source, String commentaires) {
        this.numero = numero;
        this.thematique_usage = thematique_usage;
        this.discipline = discipline;
        this.degre = degre;
        this.academie = academie;
        this.region_academique = region_academique;
        this.type_acteur = type_acteur;
        this.identite_acteur = identite_acteur;
        this.url_ressource = url_ressource;
        this.nom_ressource = nom_ressource;
        this.type_source = type_source;
        this.commentaires = commentaires;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getThematique_usage() {
        return thematique_usage;
    }

    public void setThematique_usage(String thematique_usage) { this.thematique_usage = thematique_usage; }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDegre() {
        return degre;
    }

    public void setDegre(String degre) {
        this.degre = degre;
    }

    public String getAcademie() {return academie; }

    public void setAcademie(String academie) {
        this.academie = academie;
    }

    public String getRegion_academique() {
        return region_academique;
    }

    public void setRegion_academique(String region_academique) {
        this.region_academique = region_academique;
    }

    public String getType_acteur() {
        return type_acteur;
    }

    public void setType_acteur(String type_acteur) {
        this.type_acteur = type_acteur;
    }

    public String getIdentite_acteur() {
        return identite_acteur;
    }

    public void setIdentite_acteur(String identite_acteur) {
        this.identite_acteur = identite_acteur;
    }

    public String getUrl_ressource() {
        return url_ressource;
    }

    public void setUrl_ressource(String url_ressource) {
        this.url_ressource = url_ressource;
    }

    public String getNom_ressource() {
        return nom_ressource;
    }

    public void setNom_ressource(String nom_ressource) {
        this.nom_ressource = nom_ressource;
    }

    public String getType_source() {
        return type_source;
    }

    public void setType_source(String type_source) {
        this.type_source = type_source;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public String toString() {
        return "Typologie{" +
                "numero=" + numero +
                ", thematique_usage='" + thematique_usage + '\'' +
                ", discipline='" + discipline + '\'' +
                ", degre='" + degre + '\'' +
                ", academie='" + academie + '\'' +
                ", region_academique='" + region_academique + '\'' +
                ", type_acteur='" + type_acteur + '\'' +
                ", identite_acteur='" + identite_acteur + '\'' +
                ", url_ressource='" + url_ressource + '\'' +
                ", nom_ressource='" + nom_ressource + '\'' +
                ", type_source='" + type_source + '\'' +
                ", commentaires='" + commentaires + '\'' +
                '}';
    }
}
