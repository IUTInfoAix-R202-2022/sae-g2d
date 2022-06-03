package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashMap;

@Entity
public class Academie {
    private final static HashMap<String, Academie> INSTANCES = new HashMap<>();
    @Transient
    public static Academie Mayotte = new Academie("MY", "Academie de Mayotte", RegionAcademique.Mayotte);
    @Transient
    public static Academie Besancon = new Academie("BE", "Academie de Besançon", RegionAcademique.BourgogneFrancheComte);
    @Transient
    public static Academie Bordeaux = new Academie("BO", "Academie de Bordeaux", RegionAcademique.NouvelleAquitaine);
    @Transient
    public static Academie ClermontFerrand = new Academie("CL", "Academie de Clermont-Ferrand", RegionAcademique.AuvergneRhoneAlpes);
    @Transient
    public static Academie Dijon = new Academie("DI", "Academie de Dijon", RegionAcademique.BourgogneFrancheComte);
    @Transient
    public static Academie Grenoble = new Academie("GR", "Academie de Grenoble", RegionAcademique.AuvergneRhoneAlpes);
    @Transient
    public static Academie Guadeloupe = new Academie("GU", "Academie de la Guadeloupe", RegionAcademique.Guadeloupe);
    @Transient
    public static Academie Guyane = new Academie("GA", "Academie de la Guyane", RegionAcademique.Guyane);
    @Transient
    public static Academie Martinique = new Academie("MA", "Academie de la Martinique", RegionAcademique.Martinique);
    @Transient
    public static Academie Reunion = new Academie("RE", "Academie de La Réunion", RegionAcademique.Reunion);
    @Transient
    public static Academie Limoges = new Academie("LI", "Academie de Limoges", RegionAcademique.NouvelleAquitaine);
    @Transient
    public static Academie Lyon = new Academie("LY", "Academie de Lyon", RegionAcademique.AuvergneRhoneAlpes);
    @Transient
    public static Academie Poitiers = new Academie("PO", "Academie de Poitiers", RegionAcademique.NouvelleAquitaine);
    @Transient
    public static Academie AixMarseille = new Academie("AI", "Academie d'Aix-Marseille", RegionAcademique.ProvenceAlpesCoteDAzur);
    @Transient
    public static Academie Amiens = new Academie("AM", "Academie d'Amiens", RegionAcademique.HautsDeFrance);
    @Transient
    public static Academie OrleansTours = new Academie("OR", "Academie d'Orleans-Tours", RegionAcademique.CentreValDeLoire);
    @Transient
    public static Academie Corse = new Academie("CO", "Academie de Corse", RegionAcademique.Corse);
    @Transient
    public static Academie Lille = new Academie("LL", "Academie de Lille", RegionAcademique.HautsDeFrance);
    @Transient
    public static Academie NancyMetz = new Academie("NM", "Academie de Nancy-Metz", RegionAcademique.GrandEst);
    @Transient
    public static Academie Nantes = new Academie("NA", "Academie de Nantes", RegionAcademique.PaysDeLaLoire);
    @Transient
    public static Academie Nice = new Academie("NI", "Academie de Nice", RegionAcademique.ProvenceAlpesCoteDAzur);
    @Transient
    public static Academie Normandie = new Academie("NO", "Academie de Normandie", RegionAcademique.Normandie);
    @Transient
    public static Academie Reims = new Academie("RI", "Academie de Reims", RegionAcademique.GrandEst);
    @Transient
    public static Academie Rennes = new Academie("RN", "Academie de Rennes", RegionAcademique.Bretagne);
    @Transient
    public static Academie Strasbourg = new Academie("ST", "Academie de Strasbourg", RegionAcademique.GrandEst);
    @Transient
    public static Academie Creteil = new Academie("CR", "Academie de Creteil", RegionAcademique.IleDeFrance);
    @Transient
    public static Academie Montpellier = new Academie("MO", "Academie de Montpellier", RegionAcademique.Occitanie);
    @Transient
    public static Academie Paris = new Academie("PA", "Academie de Paris", RegionAcademique.IleDeFrance);
    @Transient
    public static Academie Toulouse = new Academie("TO", "Academie de Toulouse", RegionAcademique.Occitanie);
    @Transient
    public static Academie Versailles = new Academie("VE", "Academie de Versailles", RegionAcademique.IleDeFrance);
    @Id
    String code;
    String nom;

    @ManyToOne(cascade = CascadeType.ALL)
    RegionAcademique regionAcademique;

    private Academie(String code, String nom, RegionAcademique regionAcademique) {
        this.code = code;
        this.nom = nom;
        this.regionAcademique = regionAcademique;
        INSTANCES.put(this.code, this);
    }

    public Academie() {
    }

    public static Academie get(String code) {
        return INSTANCES.get(code);
    }

    public static Collection<Academie> toutes() {
        return INSTANCES.values();
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public RegionAcademique getRegionAcademique() {
        return regionAcademique;
    }
}