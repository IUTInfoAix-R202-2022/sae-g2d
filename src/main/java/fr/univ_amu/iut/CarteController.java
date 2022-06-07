package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAOTypologieJDBC;
import fr.univ_amu.iut.database.Typologie;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarteController {

    private SceneController sceneController = new SceneController();

    private DAOTypologieJDBC dao = Main.getDaoTypologieJDBC();

    private static AcademiePath academiePath;

    private static List<Typologie> thematiquesUsageGroupByAcademie;

    private static List<Typologie> typologiesButton;

    @FXML
    private VBox vbox;

    @FXML
    private StackPane carte;

    France france;

    /**
     * Initialise une nouvelle scene
     * @param event
     * @throws IOException
     */
    @FXML
    public void switchTo(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();
        thematiquesUsageGroupByAcademie = null;

        sceneController.switchTo2(node, data);
    }

    /**
     * Initialise une nouvelle scene, configuration (tableview)
     * @throws SQLException
     */
    @FXML
    public void switchToConfigurer() throws SQLException {
        thematiquesUsageGroupByAcademie = null;
        sceneController.switchToConfigurer();
    }

    /**
     * Initialise tous les boutons du menu situé sur la gauche.
     * @throws SQLException
     */
    public void initializeButton() throws SQLException {
        typologiesButton = dao.findThematiquesUsage();
    }

    /**
     * Initialisation de la page carte, avec une carte de france, menu à gauche, etc
     */
    @FXML
    public void initialize() {
        String css = this.getClass().getResource("assets/style.css").toExternalForm();

        initialiserCarteFrance();

        carte.getChildren().addAll(france);
        carte.setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));

        // On récupère les anciennes academies sélectionnées
        if (thematiquesUsageGroupByAcademie != null) initializeColorsOfCarte(thematiquesUsageGroupByAcademie);

        initialiserBoutons(css);
    }

    /**
     * Initialiser le menu de gauche, avec les boutons contenant le nom des thématiques
     * @param stylesheet
     */
    private void initialiserBoutons(String stylesheet){
        for (Typologie t : typologiesButton) {
            if (t.getThematique_usage() != null && !t.getThematique_usage().isEmpty())
                vbox.getChildren().add(new Button(t.getThematique_usage()));
        }

        for (Node e : vbox.getChildren()) {
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
            button.getStylesheets().add(stylesheet);
            button.setPrefWidth(1000.0);
            button.setPrefHeight(1000.0);
        }
    }

    /**
     * Initialise la carte de france
     */
    private void initialiserCarteFrance(){
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
                        sceneController.switchTo2(carte, "fxml/academie.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .selectionEnabled(true)
                .build();
    }

    /**
     * Initialise les couleurs de la carte (chaque académie) lors du clique sur une thématique
     * @param list
     * @return
     */
    public AcademiePath initializeColorsOfCarte(List<Typologie> list) {
        france.setFillColor(Color.web("#b6b6ff"));
        for (Academie a : Academie.toutes()) {
            for (Typologie typologie : list) {
                if (typologie.getAcademie() != null && typologie.getAcademie().equals(a.getNom())) {
                    academiePath = AcademiePath.get(a);
                    academiePath.setFill(Color.RED);
                }
            }
        }
        return academiePath;
    }

    /**
     * Renvoie academiePath pour la carte de france
     * @return
     */
    public static AcademiePath getAcademiePath() {
        return academiePath;
    }

}
