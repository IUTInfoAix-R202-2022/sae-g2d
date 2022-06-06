package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.net.URL;

@NamedQueries({
        @NamedQuery(name = "Ressource.findAll", query = "SELECT p FROM Ressource p"),
})
@Entity
public class Ressource {
    @Id
    @GeneratedValue
    int id;
    @ManyToOne
    TypeRessource typeRessource;
    URL lienRessource;

    public Ressource(TypeRessource typeRessource, URL lienRessource) {
        this.typeRessource = typeRessource;
        this.lienRessource = lienRessource;
    }

    public Ressource() {

    }

    public TypeRessource getTypeRessource() {
        return typeRessource;
    }

    public URL getLienRessource() {
        return lienRessource;
    }

    public int getId() {
        return id;
    }
}
