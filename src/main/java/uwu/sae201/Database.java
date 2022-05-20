package uwu.sae201;

import java.sql.*;

public class Database {

    // Chaîne de connexion
    private static final String CONNECT_URL = "jdbc:postgresql://kesavan.db.elephantsql.com/cssqfxzf";
    private static final String LOGIN = "cssqfxzf";
    private static final String PASSWORD = "M6crtbHWKBQW0Cl7iXPIQeLmuCaeDMdj";

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
