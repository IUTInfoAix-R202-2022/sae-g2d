package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "TypeRessource.findAll", query = "SELECT p FROM TypeRessource p"),
})
@Entity
public class TypeRessource {
    @Id
    @GeneratedValue
    int id;
    String nom;

    public TypeRessource(String nom) {
        this.nom = nom;
    }

    public TypeRessource() {
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }
}
