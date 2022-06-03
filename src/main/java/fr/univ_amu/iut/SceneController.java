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

    private final double HEIGHT = Screen.getPrimary().getBounds().getHeight() / 1.2;
    private final double WIDTH = Screen.getPrimary().getBounds().getWidth() / 1.2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField identifiant;
    @FXML
    private TextField motDePasse;

    @FXML
    public void switchTo(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource() ;
        String data = (String) node.getUserData();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(data)));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,WIDTH,HEIGHT);
        stage.minHeightProperty().set(HEIGHT);
        stage.minWidthProperty().set(WIDTH);
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }

    public void switchTo2(Node node, String filename) throws IOException {
        root = FXMLLoader.load(getClass().getResource(filename));
        stage = (Stage) node.getScene().getWindow();
        scene = new Scene(root,WIDTH,HEIGHT);
        stage.minHeightProperty().set(HEIGHT);
        stage.minWidthProperty().set(WIDTH);
        stage.setTitle("Dico Pédago");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void verificationSwitchTo(ActionEvent event) throws SQLException, IOException {
        //Récupération du login de la BDD
        List<Utilisateur> listUtilisateur;
        listUtilisateur = initialiseDatabaseLogin();
        String hashID = listUtilisateur.get(0).getID();
        String hashMotDePasse = listUtilisateur.get(0).getMotDePasse();

        //Récupération du login entré par l'utilisateur
        List<String> loginUtilisateur;
        loginUtilisateur = initialiseUtilisateurLogin();
        String inputID = loginUtilisateur.get(0);
        String inputMotDePasse = loginUtilisateur.get(1);

        //Vérification

        if ((encryptLogin(inputID).equals(hashID)) && (encryptLogin(inputMotDePasse).equals(hashMotDePasse))) {
            System.out.println("0");
            switchTo(event);
        }
        System.out.println("1");
    }

    public List<Utilisateur> initialiseDatabaseLogin() throws SQLException {
        DAOUtilisateurJDBC daoJDBC = new DAOUtilisateurJDBC();
        List<Utilisateur> listUtilisateur;
        listUtilisateur = daoJDBC.findAll();    //Obtention du login
        return listUtilisateur;
    }

    public List<String> initialiseUtilisateurLogin() {
        List<String> login = new ArrayList<>();
        login.add(identifiant.getText());
        login.add(motDePasse.getText());
        return login;
    }

    public static String encryptLogin(String input)
    {
        try {
            //getInstance() est appelé avec l'algorithme SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            //la méthode digest() est appelé
            //pour calculer le condensé de message de la chaîne d'entrée
            //retourné sous forme de tableau d'octets
            byte[] messageDigest = md.digest(input.getBytes());

            // Convertir le tableau d'octets en représentation de signe
            BigInteger no = new BigInteger(1, messageDigest);

            // Convertir le résumé du message en valeur hexadecimale
            String hashtext = no.toString(16);

            // Ajoutez les 0 précédents pour obtenir le 32 bits.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }




}
