package fr.univ_amu.iut;

import fr.univ_amu.iut.database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {

    private static Connection connection;// On établie la connexion

    @Override
    public void start(Stage stage) throws IOException {
        connection = Database.getDBConnection();
        Parent root = FXMLLoader.load(getClass().getResource("academie.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        stage.setTitle("Dico Pédago");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Connection getDBConnection() {
        return connection;
    }
}
