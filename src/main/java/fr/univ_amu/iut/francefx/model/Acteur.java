package fr.univ_amu.iut.francefx.model;

import jakarta.persistence.*;

@Entity
public class Acteur {
    @Id
    @GeneratedValue
    int id;

    String nom;
    String prenom;

    @Embedded
    Coordonees coordonees;

    @ManyToOne
    TypeActeur typeActeur;

    public Acteur() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Coordonees getCoordonees() {
        return coordonees;
    }

    public TypeActeur getTypeActeur() {
        return typeActeur;
    }
}
