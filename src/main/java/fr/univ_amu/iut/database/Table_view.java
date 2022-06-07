package fr.univ_amu.iut.database;


import fr.univ_amu.iut.DAO.DAOTypologieJDBC;
import fr.univ_amu.iut.Main;
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

public class Table_view extends Application {

    private Connection connection = Main.getDBConnection();

    private DAOTypologieJDBC dao = Main.getDaoTypologieJDBC();

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

    private ObservableList<Typologie> donnees;

    private GridPane root;
    private TextField filtreField;
    private Label filtreLabel;
    private Button boutonAjouter;
    private Button boutonSupprimer;
    private ColumnConstraints colonne1;
    private ColumnConstraints colonne2;
    private static TableView<Typologie> table;
    private StackPane stackPane;
    private HBox bas;

    /**
     * Lancement de la page
     * @param stage
     * @throws SQLException
     */
    @Override
    public void start(Stage stage) throws SQLException {
        initialiserRoot();

        stage.setTitle("TableView");
        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initialisation du root
     * @throws SQLException
     */
    private void initialiserRoot() throws SQLException {
        root = new GridPane();
        initialiserColonnesRoot();
        initialiserTextFieldAndLabelSearchBar();
        initialiserStackPane();
        initialiserContent();
    }

    /**
     * Initialisation du stackpane
     * @throws SQLException
     */
    private void initialiserStackPane() throws SQLException {
        stackPane = new StackPane();
        stackPane.setPadding(new Insets(5));

        initialiserTableView();
        stackPane.getChildren().add(table);
        root.add(stackPane, 0, 1, 2, 1);
    }

    /**
     * Initialisation de la tableview
     * @throws SQLException
     */
    private void initialiserTableView() throws SQLException {
        table = new TableView<>();
        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );

        donnees = ajouterTypologies(); // On entre les données
        table.setItems(donnees);

        initialiserColonnes();
        initialiserBarreDeRecherche();

    }

    /**
     * Initialisation des colonnes du root
     */
    private void initialiserColonnesRoot() {
        colonne1 = new ColumnConstraints();
        colonne1.setPercentWidth(30);
        colonne1.setHgrow(Priority.SOMETIMES);
        colonne1.setHalignment(HPos.CENTER);


        colonne2 = new ColumnConstraints();
        colonne2.setPercentWidth(70);
        colonne2.setHgrow(Priority.SOMETIMES);

        root.getColumnConstraints().addAll(colonne1, colonne2);
    }

    /**
     * Initialisation du bas de la page (Bouton 'Ajouter' et 'Supprimer')
     */
    private void initialiserContent() {
        bas = new HBox();
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(5);
        initialiserBoutons();
        root.add(bas,0,5,2,1);
    }

    /**
     * Initialisation des boutons 'Ajouter' et 'Supprimer'
     */
    private void initialiserBoutons() {
        boutonAjouter = new Button("Ajouter");
        boutonSupprimer = new Button("Supprimer");

        boutonAjouter.setOnAction(event -> {
            System.out.println("ajouté");
            try {
                ajouterLigne();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        boutonSupprimer.setOnAction(event -> {
            try {
                supprimerLigne();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        bas.getChildren().addAll(boutonAjouter,boutonSupprimer);
    }

    /**
     * Ajoute une ligne dans la tableview et dans la base de données
     * @throws SQLException
     */
    private void ajouterLigne() throws SQLException {
        Typologie typologie = new Typologie();
        typologie.setNumero(table.getItems().size() + 1);
        table.scrollTo(table.getItems().size());
        donnees.add(typologie);
        dao.insert(typologie);
    }

    /**
     * Supprime la ligne sélectionnée de la tableview et de la base de données
     * @throws SQLException
     */
    private void supprimerLigne() throws SQLException {
        Typologie typologie = table.getSelectionModel().getSelectedItem();
        dao.delete(typologie);  //Suppresion dans la base de données
        donnees.remove(typologie); //Suppresion dans la tableview
    }

    /**
     * Initialise les colonnes de la tableview : numéro
     * @return TableColumn
     */
    private TableColumn<Typologie,Integer> initialiserColNumero(){
        TableColumn<Typologie, Integer> numero = new TableColumn<>("Numéro");
        numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        return numero;
    }

    /**
     * Initialise les colonnes de la tableview : thematique_usage
     * @return TableColumn
     */
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
    /**
     * Initialise les colonnes de la tableview : discipline
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : degre
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : academie
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : region_academique
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : type_acteur
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : identite_acteur
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : url_ressource
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : nom_ressource
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : type_source
     * @return TableColumn
     */
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

    /**
     * Initialise les colonnes de la tableview : commentaires
     * @return TableColumn
     */
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

    /**
     * Initialisation des colonnes de la tableview
     */
    private void initialiserColonnes() {
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
        table.getColumns().addAll(numero,thematique_usage, discipline, degre, academie, region_academique, type_acteur, identite_acteur, url_ressource, nom_ressource, type_source, commentaires);
    }

    /**
     * Ajouter tous les tuples de la base de données dans la tableview
     * @return ObservableList<Typologie>
     * @throws SQLException
     */
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

    /**
     * Initialisation de la barre de recherche
     */
    private void initialiserTextFieldAndLabelSearchBar() {
        filtreField = new TextField();
        filtreLabel = new Label("Search");
        filtreLabel.setPadding(new Insets(5));

        root.add(filtreField, 1, 0);
        root.add(filtreLabel,0,0);
    }

    /**
     * Fonctionnement de la barre de recherche
     */
    private void initialiserBarreDeRecherche() {

        // ObservableList => FilteredList
        FilteredList<Typologie> filteredData = new FilteredList<>(donnees, p -> true);

        // Listener
        filtreField.textProperty().addListener((observable, oldValue, newValue) -> {
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