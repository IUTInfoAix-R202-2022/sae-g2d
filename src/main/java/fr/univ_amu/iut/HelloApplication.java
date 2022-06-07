package fr.univ_amu.iut;

import fr.univ_amu.iut.DAO.DAOTypologieJDBC;
import fr.univ_amu.iut.DAO.DAOUtilisateurJDBC;
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

    //Declaration et initialisation des valeurs de la taille et de la longueur de la stage
    private final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;
    private final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 1.2;


    private static Connection connection;   // On établie la connexion
    private static DAOTypologieJDBC daoTypologieJDBC;
    private static DAOUtilisateurJDBC daoUtilisateurJDBC;

    /**
     * Lance l'application
     * @param stage
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void start(Stage stage) throws IOException, SQLException {

        connection = Database.getDBConnection();
        daoTypologieJDBC = new DAOTypologieJDBC();
        daoUtilisateurJDBC = new DAOUtilisateurJDBC();

        initializeButtonOfCarte();

        Parent root = FXMLLoader.load(getClass().getResource("fxml/accueil.fxml"));
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Dico Pédago");
        stage.minHeightProperty().set(HEIGHT); //Initialisation de la taille de la stage
        stage.minWidthProperty().set(WIDTH); //Initialisation de la longueur de la stage
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
        CarteController carteController = new CarteController();
        carteController.initializeButton();
    }

    public static Connection getDBConnection() {
        return connection;
    }
    public static boolean closeDBConnection(){
        return Database.closeDBConnection();
    }

    public static DAOTypologieJDBC getDaoTypologieJDBC(){return daoTypologieJDBC;}
    public static DAOUtilisateurJDBC getDaoUtilisateurJDBC(){return daoUtilisateurJDBC;}
}
