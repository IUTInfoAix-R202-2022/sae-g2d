package fr.univ_amu.iut;

import fr.univ_amu.iut.database.DAOUtilisateur;
import fr.univ_amu.iut.database.DAOUtilisateurJDBC;
import fr.univ_amu.iut.database.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SceneController {

    private static final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;
    private static final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 1.2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchTo(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();

        root = FXMLLoader.load(getClass().getResource(data));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,stage.getWidth(),stage.getHeight());
        stage.minHeightProperty().set(stage.getHeight());
        stage.minWidthProperty().set(stage.getWidth());
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }

    public void switchTo2(Node node, String filename) throws IOException {
        root = FXMLLoader.load(getClass().getResource(filename));
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root,stage.getWidth(),stage.getHeight());
        stage.minHeightProperty().set(stage.getHeight());
        stage.minWidthProperty().set(stage.getWidth());
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
    }
}
