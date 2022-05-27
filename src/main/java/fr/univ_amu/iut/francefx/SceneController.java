package fr.univ_amu.iut.francefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button accueil;

    public void switchToCarte(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("carte.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
    }
}
