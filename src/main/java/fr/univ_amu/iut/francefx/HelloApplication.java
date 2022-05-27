package fr.univ_amu.iut.francefx;

import fr.univ_amu.iut.francefx.view.map.AcademiePath;
import fr.univ_amu.iut.francefx.view.map.France;
import fr.univ_amu.iut.francefx.view.map.FranceBuilder;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("accueil.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        stage.setTitle("Dico Pédago");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}