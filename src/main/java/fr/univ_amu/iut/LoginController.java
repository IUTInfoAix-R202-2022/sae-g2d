package fr.univ_amu.iut;

import fr.univ_amu.iut.database.DAOUtilisateurJDBC;
import fr.univ_amu.iut.database.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField identifiant;
    @FXML
    private TextField motDePasse;

    @FXML
    public void callSwitchTo(ActionEvent event) throws IOException {
        SceneController s = new SceneController();
        s.switchTo(event);
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
            SceneController s = new SceneController();
            s.switchTo(event);
        }

    }

    public List<Utilisateur> initialiseDatabaseLogin() throws SQLException {
        DAOUtilisateurJDBC daoJDBC = HelloApplication.getDaoUtilisateurJDBC();
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
