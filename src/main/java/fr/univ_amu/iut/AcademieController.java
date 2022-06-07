package fr.univ_amu.iut;

import fr.univ_amu.iut.database.DAOTypologieJDBC;
import fr.univ_amu.iut.database.Typologie;
import fr.univ_amu.iut.view.map.AcademiePath;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AcademieController {

    private SceneController sceneController = new SceneController();
    private DAOTypologieJDBC dao = HelloApplication.getDaoTypologieJDBC();

    private CarteController carteController = new CarteController();

    private AcademiePath academiePath;

    @FXML
    private GridPane gridPane;

    @FXML
    private VBox vbox;

    @FXML
    private Label academie_selectionne;

    public AcademieController() throws SQLException {
    }

    @FXML
    public void switchTo() throws IOException {
        sceneController.switchTo2(gridPane,"fxml/carte.fxml");
    }

    private HBox setNewHbox(Typologie typologie){
        HBox hbox = new HBox(8);
        hbox.setId("hbox_academie");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setMinWidth(Double.NEGATIVE_INFINITY);
        hbox.setPrefWidth(100);
        hbox.getStylesheets().add(getClass().getResource("assets/academie.css").toExternalForm());


        Label label = new Label(typologie.getThematique_usage());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_usage");
        hbox.getChildren().add(label);

        label = new Label(typologie.getDiscipline());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        label = new Label(typologie.getDegre());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        label = new Label(typologie.getRegion_academique());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        label = new Label(typologie.getType_acteur());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        label = new Label(typologie.getIdentite_acteur());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        Hyperlink hl = new Hyperlink(typologie.getUrl_ressource());
        hl.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(hl);

        label = new Label(typologie.getNom_ressource());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        label = new Label(typologie.getType_source());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        label = new Label(typologie.getCommentaires());
        label.getStyleClass().addAll("labels_donnees", "labels_donnees_informations");
        hbox.getChildren().add(label);

        hbox.setPadding(new Insets(0,5,0,5));
        return hbox;
    }



    @FXML
    public void initialize() throws SQLException {
        academiePath = carteController.getAcademiePath();
        academie_selectionne.setText(academiePath.getAcademie().getNom());
        List<Typologie> donneesAcademie = dao.findByAcademie(academiePath.getAcademie().getNom());
        for (Typologie t : donneesAcademie) {
            vbox.getChildren().add(setNewHbox(t));
        }
    }







}

