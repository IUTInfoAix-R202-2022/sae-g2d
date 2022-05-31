package fr.univ_amu.iut.database;

import fr.univ_amu.iut.HelloApplication;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImportBDD extends Application {

    private String filename;
    private Connection connection = HelloApplication.getDBConnection();
    private PreparedStatement preparedStatement;
    private String req;

    private List<String> stringUsageList = new ArrayList<>();


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 551, 400);
        scene.setOnDragOver(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.MOVE);
            } else {
                event.consume();
            }
        });

        // Dropping over surface
        scene.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                String filePath=  db.getFiles().get(0).getAbsolutePath();
                System.out.println(filePath);
                filename = filePath;
            }
            event.setDropCompleted(success);
            event.consume();

            try {
                read();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void read() throws IOException, SQLException {
        {
            ModificationBDD BDD = new ModificationBDD();
            stringUsageList = BDD.initializeStringUsageList();

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String ligne = null;

            boolean verificationDesNomColonnes = true;
            req = "INSERT INTO typologie (NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);"
            ;
            preparedStatement = connection.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            while ((ligne = br.readLine()) != null)
            {
                // Retourner la ligne dans un tableau
                String[] data = ligne.split(", ");
                System.out.println("data : " + data.length);

                // Afficher le contenu du tableau
                for (int i = 0; i < data.length; ++i)
                {
                    if (verificationDesNomColonnes){
                        if (!stringUsageList.contains(data[i].toUpperCase())){
                            System.out.println("erreur");
                            return;
                        }
                    } else {
                        preparedStatement.setString(i+2, data[i]);
                    }
                    System.out.println(data[i]);
                }
                if (!verificationDesNomColonnes){
                    ModificationBDD.setNumeroByCount();
                    preparedStatement.setInt( 1,ModificationBDD.numero);

                    preparedStatement.executeUpdate();
                }
                verificationDesNomColonnes = false;
            }
            br.close();
        }
    }



}
