package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Academie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Servira à avoir un menu déroulant contenant l'ensemble des académies disponibles dans la tableview
 */
public class ListAcademies {

    private static ObservableList<String> academiesList = FXCollections.observableArrayList();

    /**
     * Obtenir l'ensemble des noms des academies
     * @return academiesList
     */
    public static ObservableList<String> getAcademiesList(){
        academiesList.add(Academie.Corse.getNom());
        academiesList.add(Academie.Versailles.getNom());
        academiesList.add(Academie.AixMarseille.getNom());
        academiesList.add(Academie.Amiens.getNom());
        academiesList.add(Academie.Besancon.getNom());
        academiesList.add(Academie.Bordeaux.getNom());
        academiesList.add(Academie.ClermontFerrand.getNom());
        academiesList.add(Academie.Creteil.getNom());
        academiesList.add(Academie.Dijon.getNom());
        academiesList.add(Academie.Grenoble.getNom());
        academiesList.add(Academie.Guadeloupe.getNom());
        academiesList.add(Academie.Guyane.getNom());
        academiesList.add(Academie.Lille.getNom());
        academiesList.add(Academie.Limoges.getNom());
        academiesList.add(Academie.Lyon.getNom());
        academiesList.add(Academie.Martinique.getNom());
        academiesList.add(Academie.Mayotte.getNom());
        academiesList.add(Academie.Montpellier.getNom());
        academiesList.add(Academie.NancyMetz.getNom());
        academiesList.add(Academie.Nantes.getNom());
        academiesList.add(Academie.Nice.getNom());
        academiesList.add(Academie.Normandie.getNom());
        academiesList.add(Academie.OrleansTours.getNom());
        academiesList.add(Academie.Paris.getNom());
        academiesList.add(Academie.Poitiers.getNom());
        academiesList.add(Academie.Reims.getNom());
        academiesList.add(Academie.Rennes.getNom());
        academiesList.add(Academie.Reunion.getNom());
        academiesList.add(Academie.Strasbourg.getNom());
        academiesList.add(Academie.Toulouse.getNom());
        return academiesList;
    }
}
