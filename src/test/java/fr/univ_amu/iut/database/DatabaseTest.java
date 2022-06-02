/*
package fr.univ_amu.iut.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DatabaseTest {

    @Test
    public void devrait_effectue_le_lien_avec_la_bdd() {
        assertNotEquals(Database.getDBConnection(),null);
    }

    @Test
    public void devrait_ajouter_tuple_dans_la_bdd() throws SQLException {
        Connection connection = Database.getDBConnection();
        ModificationBDD.setNumeroByCount();
        int oldNumero = ModificationBDD.numero - 1;

        String requete_ajout = "INSERT INTO typologie " +
                "(NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(requete_ajout, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1,oldNumero + 1);
        for (int i = 2; i < 13; ++i) {
            preparedStatement.setString(i, "x");
        }

        preparedStatement.executeUpdate();

        ModificationBDD.setNumeroByCount();
        int newNumero = ModificationBDD.numero - 1;

        assertEquals(newNumero, oldNumero + 1);
    }

    @Test
    public void deverait_supprimer_tuple_dans_la_bdd() throws SQLException {
        devrait_ajouter_tuple_dans_la_bdd();

        Connection connection = Database.getDBConnection();
        ModificationBDD.setNumeroByCount();
        int oldNumero = ModificationBDD.numero - 1;

        String requete_suppression = "DELETE FROM typologie WHERE DISCIPLINE=?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete_suppression, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, "x");
        preparedStatement.executeUpdate();

        ModificationBDD.setNumeroByCount();
        int newNumero = ModificationBDD.numero - 1;

        assertEquals(newNumero, oldNumero - 1);
    }
}
*/
