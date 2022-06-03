package fr.univ_amu.iut;

import fr.univ_amu.iut.database.DAOTypologieJDBC;
import fr.univ_amu.iut.database.Database;
import fr.univ_amu.iut.database.Typologie;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private SceneController sceneController = new SceneController();

    private Connection connection = HelloApplication.getDBConnection();

    private DAOTypologieJDBC dao = new DAOTypologieJDBC();

    private static AcademiePath academiePath;

    private static List<Typologie> thematiquesUsageGroupByAcademie;

    @FXML
    private VBox vbox;

    @FXML
    private StackPane carte;

    France france;

    List<String> colors = new ArrayList<>();

    // La requête de test
    static final String req = "SELECT DISTINCT THEMATIQUE_USAGE " +
                            "FROM typologie ";


    public Jdbc() throws SQLException {
    }

    @FXML
    public void switchTo() throws IOException {
        sceneController.switchTo2(carte,"accueil.fxml");
    }
    @FXML
    public void initialize(){
        String css = this.getClass().getResource("style.css").toExternalForm();

        france = FranceBuilder.create()
                .backgroundColor(Color.web("#FFFFFF"))
                .fillColor(Color.web("#b6b6ff"))
                .strokeColor(Color.web("#000000"))
                .hoverColor(Color.web("#5858cd"))
                .pressedColor(Color.web("#FFFFFF"))
                .selectedColor(Color.web("#b81111"))
                .mousePressHandler(evt -> {
                    academiePath = (AcademiePath) evt.getSource();
                   try {
                        sceneController.switchTo2(carte,"academie.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .selectionEnabled(true)
                .build();

        carte.getChildren().addAll(france);
        carte.setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));

        /**
         * On récupère les anciennes academies sélectionnées
         */
        if (thematiquesUsageGroupByAcademie != null){
            initializeColorsOfCarte(thematiquesUsageGroupByAcademie);
        }

        colors.add("rgba(25, 241, 228, 1)");
        colors.add("rgba(66, 187, 255, 0.68)");
        colors.add("rgba(75, 12, 255, 0.68)");
        colors.add("rgba(47, 59, 101, 0.68)");
        colors.add("rgba(255, 0, 0, 0.68)");
        colors.add("rgba(244, 84, 34, 1)");
        colors.add("rgba(255, 179, 66, 1)");
        colors.add("rgba(255, 215, 7, 1)");
        colors.add("rgba(160, 255, 66, 1)");
        colors.add("rgba(66, 255, 119, 0.68)");
        colors.add("rgba(79, 183, 90, 1)");
        colors.add("rgba(55, 125, 44, 1)");

        try {
            Statement statement = connection.createStatement();

            ResultSet rset = statement.executeQuery(req);

            while(rset.next()) {
                vbox.getChildren().add(new Button(rset.getString("THEMATIQUE_USAGE")));
            }

            int i = 0;
            for (Node e : vbox.getChildren()){
                if (i > colors.size() - 1) { i = 0; }
                Button button = (Button) e;
                button.setOnAction(event -> {
                    try {
                        thematiquesUsageGroupByAcademie = dao.findByThematiquesUsageGroupByAcademie(button.getText());
                        initializeColorsOfCarte(thematiquesUsageGroupByAcademie);
                        } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                button.setId("button");
                button.getStylesheets().add(css);
                button.setStyle("-fx-background-color: " + colors.get(i));
                button.setPrefWidth(1000.0);
                button.setPrefHeight(1000.0);
                ++i;
            }
            // Fermeture de l'instruction (libération des ressources)
            statement.close();
            System.out.println("\nOk.\n");

        } catch (SQLException e) {
            //Ceci n'est pas une gestion réaliste des erreurs
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }


    /**
     *
     * @param list
     * @
     */
    public void initializeColorsOfCarte(List<Typologie> list){
        france.setFillColor(Color.web("#b6b6ff"));
        for (Academie a : Academie.toutes()){
            for (Typologie typologie : list){
                if (typologie.getAcademie().equals(a.getNom())){
                    academiePath = AcademiePath.get(a);
                    academiePath.setFill(Color.RED);
                }
            }
        }
    }

    public static AcademiePath getAcademiePath() {
        return academiePath;
    }

}
