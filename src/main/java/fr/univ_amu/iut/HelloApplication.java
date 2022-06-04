package fr.univ_amu.iut;

import fr.univ_amu.iut.database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloApplication extends Application {

    private final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;
    private final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 1.2;


    private static Connection connection;// On établie la connexion

    @Override
    public void start(Stage stage) throws IOException, SQLException {

        connection = Database.getDBConnection();
        initializeButtonOfCarte();

        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Dico Pédago");
        stage.minHeightProperty().set(HEIGHT);
        stage.minWidthProperty().set(WIDTH);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * initializeButtonOfCarte
     * Génére une requête SQL avant le lancement de l'application pour gagner de la vitesse et réduire la latence
     *
     * @throws SQLException
     */
    public void initializeButtonOfCarte() throws SQLException {
        Jdbc jdbc = new Jdbc();
        jdbc.initializeButton();
    }


    public static Connection getDBConnection() {
        return connection;
    }
}
