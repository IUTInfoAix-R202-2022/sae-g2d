package fr.univ_amu.iut;

import fr.univ_amu.iut.database.Database;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.event.ActionEvent;
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

    @FXML
    public void switchTo(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();

        root = FXMLLoader.load(getClass().getResource(data));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root,1280,850);
        stage.minHeightProperty().set(850);
        stage.minWidthProperty().set(1280);
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
    }


    /*
       On instancie HelloApplication pour récupérer le lien de la bdd pour éviter de le faire à chaque fois
    */
    HelloApplication rootApplication = new HelloApplication();

    @FXML
    private VBox vbox;

    @FXML
    private StackPane carte;

    France france;

    List<String> colors = new ArrayList<>();

    // La requête de test
    static final String req = "SELECT DISTINCT THEMATIQUE_USAGE " +
                            "FROM typologie ";

    @FXML
    public void initialize(){

        SceneController sc = new SceneController();

        String css = this.getClass().getResource("style.css").toExternalForm();

        france = FranceBuilder.create()
                .backgroundColor(Color.web("#FFFFFF"))
                .fillColor(Color.web("#b6b6ff"))
                .strokeColor(Color.web("#000000"))
                .hoverColor(Color.web("#5858cd"))
                .pressedColor(Color.web("#FFFFFF"))
                .selectedColor(Color.web("#b81111"))
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();

                    try {
                        sc.switchTo2(carte,"academie.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());
                })
                .selectionEnabled(true)
                .build();

        carte.getChildren().addAll(france);
        carte.setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));

        Connection connection = null;
        Statement statement = null;

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
            connection = rootApplication.getDBConnection();
            statement = connection.createStatement();

            System.out.println("Execution de la requête : " + req );
            ResultSet rset = statement.executeQuery(req);

            while(rset.next()) {
                vbox.getChildren().add(new Button(rset.getString("THEMATIQUE_USAGE")));
            }

            int i = 0;

            for (Node e : vbox.getChildren()){
                if (i > colors.size() - 1) { i = 0; }
                Button button = (Button) e;
                button.setId("button");
                button.getStylesheets().add(css);
                button.setStyle("-fx-background-color: " + colors.get(i));
                button.setPrefWidth(1000.0);
                button.setPrefHeight(1000.0);
                System.out.println(button.getText());
                ++i;
            }
            // Fermeture de l'instruction (libération des ressources)
            statement.close();

            System.out.println("\nOk.\n");

        } catch (SQLException e) {
            //Ceci n'est pas une gestion réaliste des erreurs
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
            System.out.println("Diconnected");
        }
    }
}
