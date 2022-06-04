package fr.univ_amu.iut.database;


import fr.univ_amu.iut.HelloApplication;
import fr.univ_amu.iut.ListAcademies;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Table_view extends Application {

    private Connection connection = HelloApplication.getDBConnection();

    private DAOTypologieJDBC dao = HelloApplication.getDaoTypologieJDBC();

    private static TableView<Typologie> table;

    private TextField filterField;

    private Label filterLabel;


    private Button buttonAdd;
    private Button buttonDelete;

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

    public Table_view() throws SQLException {
    }

    // private static TableColumn
    @Override
    public void start(Stage stage) throws SQLException {

        GridPane root = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        column1.setHgrow(Priority.SOMETIMES);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70);
        column1.setHgrow(Priority.SOMETIMES);

        root.getColumnConstraints().addAll(column1, column2);

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

        filterField = new TextField();
        filterLabel = new Label("Search");
        column1.setHalignment(HPos.CENTER);
        filterLabel.setPadding(new Insets(5));

        // Search
        initialiserSearchBar();

        root.add(filterField, 1, 0);
        root.add(filterLabel,0,0);
        root.add(tableview, 0, 1, 2, 1);

        HBox content = new HBox();

        buttonAdd = new Button("Ajouter");
        buttonDelete = new Button("Supprimer");

        buttonAdd.setOnAction(event -> {
            System.out.println("ajouté");
            try {
                ajouterLigne();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        buttonDelete.setOnAction(event -> {
            try {
                supprimerLigne();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        content.getChildren().addAll(buttonAdd,buttonDelete);

        root.add(content,0,5,2,1);
        content.setAlignment(Pos.CENTER);
        content.setSpacing(5);

        stage.setTitle("TableView");
        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }


    private void ajouterLigne() throws SQLException {
        Typologie typologie = new Typologie();
        typologie.setNumero(table.getItems().size() + 1);
        table.scrollTo(table.getItems().size());
        data.add(typologie);
        dao.insert(typologie);
    }

    private void supprimerLigne() throws SQLException {
        Typologie typologie = table.getSelectionModel().getSelectedItem();
        dao.delete(typologie);

        data.remove(typologie);
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return degre;
    }
    private TableColumn<Typologie,String> initialiserColAcademie(){
        ObservableList<String> academiesList = FXCollections.observableArrayList(ListAcademies.getAcademiesList());

        TableColumn<Typologie, String> academie = new TableColumn<>("Académie");
        academie.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Typologie, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Typologie, String> param) {
                Typologie t = param.getValue();
                String academie = t.getAcademie();
                return new SimpleObjectProperty<>(academie);
            }
        });
        academie.setCellFactory(ComboBoxTableCell.forTableColumn(academiesList));
        academie.setOnEditCommit(event-> {
            TablePosition<Typologie, String> pos = event.getTablePosition();
            String nouveau = event.getNewValue();
            Typologie typologie = event.getTableView().getItems().get(pos.getRow());
            typologie.setAcademie(nouveau);
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            try {
                dao.update(typologie);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return commentaires;
    }

    private void initialiserColonnes() throws SQLException {
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
        //statement.close();
        //connection.close();
        return list;

    }

    private void initialiserSearchBar() {
        // ObservableList => FilteredList
        FilteredList<Typologie> filteredData = new FilteredList<>(data, p -> true);

        // Listener
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(filterWords -> {
                // si le texte est vide, on laisse comme c'était
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Comparaison de l'academie de chaque tuple avec le filtre
                String lowerCaseFilter = newValue.toLowerCase();

                if ((filterWords.getAcademie() != null) && (filterWords.getAcademie().toLowerCase().contains(lowerCaseFilter))){
                    return true;
                } else if ((filterWords.getDiscipline() != null) && (filterWords.getDiscipline().toLowerCase().contains(lowerCaseFilter))) {
                    return true;
                } else if ((filterWords.getThematique_usage() != null) && (filterWords.getThematique_usage().toLowerCase().contains(lowerCaseFilter))) {
                    return true;
                } else if ((filterWords.getDegre() != null) && (filterWords.getDegre().toLowerCase().contains(lowerCaseFilter))) {
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
}
