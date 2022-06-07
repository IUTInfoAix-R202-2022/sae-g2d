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

    /**
     * Constructeur par défaut de la clase Typologie
     */
    public Typologie(){
    }

    /**
     * Contruteur de la classe Typologie
     * @param numero
     * @param thematique_usage
     * @param discipline
     * @param degre
     * @param academie
     * @param region_academique
     * @param type_acteur
     * @param identite_acteur
     * @param url_ressource
     * @param nom_ressource
     * @param type_source
     * @param commentaires
     */
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

    /**
     * Obtenir numero de la typologie
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifier le numero de la typologie
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtenir la thematique usage de la typologie
     * @return thematique_usage
     */
    public String getThematique_usage() {
        return thematique_usage;
    }

    /**
     * Modifier la thematique usage de la typologie
     * @param thematique_usage
     */
    public void setThematique_usage(String thematique_usage) { this.thematique_usage = thematique_usage; }

    /**
     * Obtenir la discipline de la typologie
     * @return discipline
     */
    public String getDiscipline() {
        return discipline;
    }

    /**
     * Modifier la discipline de la typologie
     * @param discipline
     */
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    /**
     * Obtenir le degre de la typologie
     * @return degre
     */
    public String getDegre() {
        return degre;
    }

    /**
     * Modifier le degre de la typologie
     * @param degre
     */
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

    /**
     * Retourne le tuple
     * @return String
     */
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
