package fr.univ_amu.iut.database;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    /**
     * Chaine de connection, URL, LOGIN, PASSWORD
     */
    private static final String CONNECT_URL = "jdbc:postgresql://kesavan.db.elephantsql.com/cssqfxzf";
    private static final String LOGIN = "cssqfxzf";
    private static final String PASSWORD = "M6crtbHWKBQW0Cl7iXPIQeLmuCaeDMdj";

    /**
     * Retourne la connection direct de la base de données ElephantSQL
     *
     * @return
     */
    public static Connection getDBConnection(){
        Connection connection = null;

        // Connexion a la base
        System.out.println("Connexion a " + CONNECT_URL);

        try {
            connection = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);
            System.out.println("Lien effectue avec la base de données. Connecte\n");
            return connection;

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
            System.out.println("Lien non effectue avec la base de données. Deconnecte\n");
        }
        return null;
    }
}
