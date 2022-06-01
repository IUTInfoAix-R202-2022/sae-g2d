package fr.univ_amu.iut.database;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table_view extends Application {
    private static TableView<Typologie> table;
    private ObservableList<Typologie> data;

    // private static TableColumn
    @Override
    public void start(Stage stage) throws SQLException {

        table = new TableView<>();


        TableColumn<Typologie, Integer> numero //
                = new TableColumn<>("Numéro");
        TableColumn<Typologie, Integer> thematique_usage //
                = new TableColumn<>("Thématique_usage");
        TableColumn<Typologie, Integer> discipline //
                = new TableColumn<>("Discipline");
        TableColumn<Typologie, Integer> degre //
                = new TableColumn<>("Degré");
        TableColumn<Typologie, Integer> academie //
                = new TableColumn<>("Académie");
        TableColumn<Typologie, Integer> region_academique //
                = new TableColumn<>("Region Acédemique");
        TableColumn<Typologie, Integer> type_acteur //
                = new TableColumn<>("Type Acteur");
        TableColumn<Typologie, Integer> identité_acteur //
                = new TableColumn<>("Identité Acteur");
        TableColumn<Typologie, Integer> url_ressource //
                = new TableColumn<>("url ressource");
        TableColumn<Typologie, Integer> nom_ressource //
                = new TableColumn<>("Nom ressource");
        TableColumn<Typologie, Integer> type_source //
                = new TableColumn<>("Type source");
        TableColumn<Typologie, Integer> commentaires //
                = new TableColumn<>("Comentaires");





        ObservableList <Typologie>list = listerActeurs();
        table.setItems(list);

        table.getColumns().addAll(numero,thematique_usage, discipline, degre, academie, region_academique, type_acteur, identité_acteur, url_ressource, nom_ressource, type_source, commentaires);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);

        stage.show();
    }



    private ObservableList<Typologie> listerActeurs() throws SQLException {


        Connection connection = Database.getDBConnection();
        Statement statement = connection.createStatement();

        String findAll = "SELECT * FROM typologie;";
        ResultSet rset = statement.executeQuery(findAll);

        ObservableList<Typologie> list = FXCollections.observableArrayList();

        while(rset.next()){
            Typologie t = new Typologie();
            t.setNumero(rset.getInt(1));
            t.setThematique_usage(rset.getString(2));
            t.setDiscipline(rset.getString(3));
            t.setDegre(rset.getString(4));
            t.setAcademie(rset.getString(5));
            t.setRegion_academique(rset.getString(6));
            t.setType_acteur(rset.getString(7));
            t.setIdentite_acteur(rset.getString(8));
            t.setUrl_ressource(rset.getString(9));
            t.setType_source(rset.getString(10));
            t.setCommentaires(rset.getString(11));
            list.add(t);
        }
        statement.close();
        return list;

    }


}
