package uwu.sae201;

import java.sql.*;

public class Jdbc {
    // Chaîne de connexion
    static final String CONNECT_URL = "jdbc:postgresql://kesavan.db.elephantsql.com/cssqfxzf";
    static final String LOGIN = "cssqfxzf";
    static final String PASSWORD = "M6crtbHWKBQW0Cl7iXPIQeLmuCaeDMdj";

    // La requête de test
    static final String req = "SELECT * " +
                            "FROM test ";


    public static void main(String[] args) throws SQLException {

        // Connexion a la base
        System.out.println("Connexion a " + CONNECT_URL);

        try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();

            // Fermeture de l'instruction (libération des ressources)
            stmt.close();
        } catch (SQLException e) {
            //Ceci n'est pas une gestion réaliste des erreurs
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
            System.out.println("Diconnected");
        }
    }
}
