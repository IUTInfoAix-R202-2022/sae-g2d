package fr.univ_amu.iut.database;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table_view extends Application {
    private static TableView<Typologie> table;
    private TextField filterAcademieField;
    private TextField filterThematiqueUsageField;
    private TextField filterDisciplineField;
    private TextField filterDegreField;
    private TableColumn<Typologie,Integer> numero;
    private TableColumn<Typologie,String> thematique_usage;
    private TableColumn<Typologie,String> discipline;
    private TableColumn<Typologie,String> degre;
    private TableColumn<Typologie,String> academie;
    private TableColumn<Typologie,String> region_academique;
    private TableColumn<Typologie,String> type_acteur;
    private TableColumn<Typologie,String> identite_acteur;
    private TableColumn<Typologie,String> url_ressource;
    private TableColumn<Typologie,String> nom_ressource;
    private TableColumn<Typologie,String> type_source;
    private TableColumn<Typologie,String> commentaires;

    private ObservableList<Typologie> data;

    // private static TableColumn
    @Override
    public void start(Stage stage) throws SQLException {

        BorderPane root = new BorderPane();

        table = new TableView<>();
        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );

        initialiserColonnes();
        table.getColumns().addAll(numero,thematique_usage, discipline, degre, academie, region_academique, type_acteur, identite_acteur, url_ressource, nom_ressource, type_source, commentaires);


        data = ajouterTypologies(); // On entre les données
        table.setItems(data);

        StackPane tableview = new StackPane();
        tableview.setPadding(new Insets(5));
        tableview.getChildren().add(table);

        filterAcademieField = new TextField();
        root.setTop(filterAcademieField);
        root.setCenter(tableview);

        // Search
        initialiserAllSearchBar();

        stage.setTitle("TableView (o7planning.org)");
        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    private TableColumn<Typologie,Integer> initialiserColNumero(){
        TableColumn<Typologie, Integer> numero = new TableColumn<>("Numéro");
        numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        return numero;
    }
    private TableColumn<Typologie,String> initialiserColThematique_usage(){
        TableColumn<Typologie, String> thematique_usage = new TableColumn<>("Thématique_usage");
        thematique_usage.setCellValueFactory(new PropertyValueFactory<>("thematique_usage"));
        thematique_usage.setCellFactory(TextFieldTableCell.forTableColumn());
        thematique_usage.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setThematique_usage(nouveau);
            System.out.println(typologie);
        });
        return thematique_usage;
    }
    private TableColumn<Typologie,String> initialiserColDiscipline(){
        TableColumn<Typologie, String> discipline = new TableColumn<>("Discipline");
        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));
        discipline.setCellFactory(TextFieldTableCell.forTableColumn());
        discipline.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setDiscipline(nouveau);
            System.out.println(typologie);
        });
        return discipline;
    }
    private TableColumn<Typologie,String> initialiserColDegre(){
        TableColumn<Typologie, String> degre = new TableColumn<>("Degré");
        degre.setCellValueFactory(new PropertyValueFactory<>("degre"));
        degre.setCellFactory(TextFieldTableCell.forTableColumn());
        degre.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setDegre(nouveau);
            System.out.println(typologie);
        });
        return degre;
    }
    private TableColumn<Typologie,String> initialiserColAcademie(){
        TableColumn<Typologie, String> academie = new TableColumn<>("Académie");
        academie.setCellValueFactory(new PropertyValueFactory<>("academie"));
        academie.setCellFactory(TextFieldTableCell.forTableColumn());
        academie.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setAcademie(nouveau);
            System.out.println(typologie);
        });
        return academie;
    }
    private TableColumn<Typologie,String> initialiserColRegion_academique(){
        TableColumn<Typologie, String> region_academique = new TableColumn<>("Region_Acédemique");
        region_academique.setCellValueFactory(new PropertyValueFactory<>("region_academique"));
        region_academique.setCellFactory(TextFieldTableCell.forTableColumn());
        region_academique.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setRegion_academique(nouveau);
            System.out.println(typologie);
        });
        return region_academique;
    }
    private TableColumn<Typologie,String> initialiserColType_acteur(){
        TableColumn<Typologie, String> type_acteur = new TableColumn<>("Type_Acteur");
        type_acteur.setCellValueFactory(new PropertyValueFactory<>("type_acteur"));
        type_acteur.setCellFactory(TextFieldTableCell.forTableColumn());
        type_acteur.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setType_acteur(nouveau);
            System.out.println(typologie);
        });
        return type_acteur;
    }
    private TableColumn<Typologie,String> initialiserColIdentite_acteur(){
        TableColumn<Typologie, String> identite_acteur = new TableColumn<>("Identité_Acteur");
        identite_acteur.setCellValueFactory(new PropertyValueFactory<>("identite_acteur"));
        identite_acteur.setCellFactory(TextFieldTableCell.forTableColumn());
        identite_acteur.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setIdentite_acteur(nouveau);
            System.out.println(typologie);
        });
        return identite_acteur;
    }
    private TableColumn<Typologie,String> initialiserColUrl_ressource(){
        TableColumn<Typologie, String> url_ressource = new TableColumn<>("Url_ressource");
        url_ressource.setCellValueFactory(new PropertyValueFactory<>("url_ressource"));
        url_ressource.setCellFactory(TextFieldTableCell.forTableColumn());
        url_ressource.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setUrl_ressource(nouveau);
            System.out.println(typologie);
        });
        return url_ressource;
    }
    private TableColumn<Typologie,String> initialiserColNom_ressource(){
        TableColumn<Typologie, String> nom_ressource = new TableColumn<>("Nom_ressource");
        nom_ressource.setCellValueFactory(new PropertyValueFactory<>("nom_ressource"));
        nom_ressource.setCellFactory(TextFieldTableCell.forTableColumn());
        nom_ressource.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setNom_ressource(nouveau);
            System.out.println(typologie);
        });
        return nom_ressource;
    }
    private TableColumn<Typologie,String> initialiserColType_source(){
        TableColumn<Typologie, String> type_source = new TableColumn<>("Type_source");
        type_source.setCellValueFactory(new PropertyValueFactory<>("type_source"));
        type_source.setCellFactory(TextFieldTableCell.forTableColumn());
        type_source.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setType_source(nouveau);
            System.out.println(typologie);
        });
        return type_source;
    }
    private TableColumn<Typologie,String> initialiserColCommentaires(){
        TableColumn<Typologie, String> commentaires = new TableColumn<>("Comentaires");
        commentaires.setCellValueFactory(new PropertyValueFactory<>("commentaires"));
        commentaires.setCellFactory(TextFieldTableCell.forTableColumn());
        commentaires.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setCommentaires(nouveau);
            System.out.println(typologie);
        });
        return commentaires;
    }

    private void initialiserColonnes(){
        numero = initialiserColNumero();
        thematique_usage = initialiserColThematique_usage();
        discipline = initialiserColDiscipline();
        degre = initialiserColDegre();
        academie = initialiserColAcademie();
        region_academique = initialiserColRegion_academique();
        type_acteur = initialiserColType_acteur();
        identite_acteur = initialiserColIdentite_acteur();
        url_ressource = initialiserColUrl_ressource();
        nom_ressource = initialiserColNom_ressource();
        type_source = initialiserColType_source();
        commentaires = initialiserColCommentaires();
    }


    private ObservableList<Typologie> ajouterTypologies() throws SQLException {


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

    private void initialiserAllSearchBar() {
        initialiserAcademieSearchBar();
        /*
        initialiserThematiqueUsageSearchBar();
        initialiserDisciplineSearchBar();
        initialiserDegreSearchBar();
         */
    }

    private void initialiserAcademieSearchBar() {
        // ObservableList => FilteredList
        FilteredList<Typologie> filteredData = new FilteredList<>(data, p -> true);

        // Listener
        filterAcademieField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(filterWords -> {
                // si le texte est vide, on laisse comme c'était
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Comparaison de l'academie de chaque tuple avec le filtre
                String lowerCaseFilter = newValue.toLowerCase();

                if (filterWords.getAcademie() == null) {
                    return false;
                } else if (filterWords.getAcademie().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        // FilteredList => SortedList.
        SortedList<Typologie> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // Ajout des académies filtrées dans la table.
        table.setItems(sortedData);
    }

    private void initialiserThematiqueUsageSearchBar() {
        // ObservableList => FilteredList
        FilteredList<Typologie> filteredData = new FilteredList<>(data, p -> true);

        // Listener
        filterThematiqueUsageField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(filterWords -> {
                // si le texte est vide, on laisse comme c'était
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Comparaison de la thématique de chaque tuple avec le filtre
                String lowerCaseFilter = newValue.toLowerCase();

                if (filterWords.getThematique_usage() == null) {
                    return false;
                } else if (filterWords.getThematique_usage().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        // FilteredList => SortedList.
        SortedList<Typologie> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // Ajout des thématiques filtrées dans la table.
        table.setItems(sortedData);
    }

    private void initialiserDisciplineSearchBar() {
        // ObservableList => FilteredList
        FilteredList<Typologie> filteredData = new FilteredList<>(data, p -> true);

        // Listener
        filterDisciplineField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(filterWords -> {
                // si le texte est vide, on laisse comme c'était
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Comparaison de la discipline de chaque tuple avec le filtre
                String lowerCaseFilter = newValue.toLowerCase();

                if (filterWords.getDiscipline() == null) {
                    return false;
                } else if (filterWords.getDiscipline().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        // FilteredList => SortedList.
        SortedList<Typologie> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // Ajout des disciplines filtrées dans la table.
        table.setItems(sortedData);
    }

    private void initialiserDegreSearchBar() {
        // ObservableList => FilteredList
        FilteredList<Typologie> filteredData = new FilteredList<>(data, p -> true);

        // Listener
        filterDegreField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(filterWords -> {
                // si le texte est vide, on laisse comme c'était
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Comparaison du degre de chaque tuple avec le filtre
                String lowerCaseFilter = newValue.toLowerCase();

                if (filterWords.getDegre() == null) {
                    return false;
                } else if (filterWords.getDegre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        // FilteredList => SortedList.
        SortedList<Typologie> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // Ajout des degrés filtrés dans la table.
        table.setItems(sortedData);
    }

    private void deleteRowsSelected(ActionEvent event){
        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }
}
