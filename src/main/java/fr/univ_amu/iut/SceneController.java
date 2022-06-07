package fr.univ_amu.iut;

import fr.univ_amu.iut.database.Table_view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static String data;

    /**
     * Retourne la data (nom du fichier fxml)
     * @return
     */
    public static String getData() { return data; }

    /**
     * Méthode permettant de changer de scène avec ActionEvent. data contient le nom du fichier source fxml.
     * @param event
     * @throws IOException
     */
    @FXML
    public void switchTo(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource() ;
        data = (String) node.getUserData();

        root = FXMLLoader.load(getClass().getResource(data));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,stage.getMinWidth(),stage.getMinHeight());
        stage.minHeightProperty().set(stage.getMinHeight());
        stage.minWidthProperty().set(stage.getMinWidth());
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Méthode permettant de changer de scène sans ActionEvent.
     * @param node : contient le noeud courant
     * @param filename : nom du fichier source
     * @throws IOException
     */
    public void switchTo2(Node node, String filename) throws IOException {
        root = FXMLLoader.load(getClass().getResource(filename));
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root,stage.getMinWidth(),stage.getMinHeight());
        stage.minHeightProperty().set(stage.getMinHeight());
        stage.minWidthProperty().set(stage.getMinWidth());
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Méthode permettant de changer de scène et d'aller vers la configuration de la BDD
     * @throws SQLException
     */
    public void switchToConfigurer() throws SQLException {
        Table_view tb = new Table_view();
        Stage stage = new Stage();
        tb.start(stage);
    }
}
