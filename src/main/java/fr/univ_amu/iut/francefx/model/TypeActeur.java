package fr.univ_amu.iut.francefx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TypeActeur {
    @Id
    @GeneratedValue
    int id;
    String nom;

    public TypeActeur(String nom) {
        this.nom = nom;
    }

    public TypeActeur() {

    }

    public String getNom() {
        return nom;
    }
}
