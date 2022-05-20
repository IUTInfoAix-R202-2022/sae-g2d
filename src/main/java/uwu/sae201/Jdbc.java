package uwu.sae201;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {

    @FXML
    private VBox vbox;

    List<String> colors = new ArrayList<>();

    // Chaîne de connexion
    static final String CONNECT_URL = "jdbc:postgresql://kesavan.db.elephantsql.com/cssqfxzf";
    static final String LOGIN = "cssqfxzf";
    static final String PASSWORD = "M6crtbHWKBQW0Cl7iXPIQeLmuCaeDMdj";

    // La requête de test
    static final String req = "SELECT DISTINCT * " +
                            "FROM test ";


    public void initialize(){

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

        System.out.println("main");
        // Connexion a la base
        System.out.println("Connexion a " + CONNECT_URL);

        try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();

            System.out.println("Execution de la requête : " + req );
            ResultSet rset = stmt.executeQuery(req);

            while(rset.next()) {
                vbox.getChildren().add(new Button(rset.getString("TEXT")));
            }

            String css = this.getClass().getResource("style.css").toExternalForm();

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
            stmt.close();

            System.out.println("\nOk.\n");

        } catch (SQLException e) {
            //Ceci n'est pas une gestion réaliste des erreurs
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
            System.out.println("Diconnected");
        }
    }
}
