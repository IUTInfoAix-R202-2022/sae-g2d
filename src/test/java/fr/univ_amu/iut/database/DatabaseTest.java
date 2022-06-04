
package fr.univ_amu.iut.database;

import fr.univ_amu.iut.HelloApplication;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class DatabaseTest {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            DatabaseTest.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(DatabaseTest.this.stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void devrait_effectue_le_lien_avec_la_bdd() {
        Connection connection = HelloApplication.getDBConnection();
        assertNotEquals(connection,null);

    }
    @Test
    public void devrait_ajouter_tuple_dans_la_bdd() throws SQLException {
        DAOTypologieJDBC dao = new DAOTypologieJDBC();
        Typologie test = new Typologie(1,"x","x","x","x","x","x","x","x","x","x","x");
        assertEquals(dao.insert(test),test);

        test.setNumero(dao.setNumeroByCount() - 1);
        dao.delete(test);
    }

   @Test
    public void deverait_supprimer_tuple_dans_la_bdd() throws SQLException {
        DAOTypologieJDBC dao = new DAOTypologieJDBC();
        int actualNumero = dao.setNumeroByCount();

        Typologie test = new Typologie(1,"x","x","x","x","x","x","x","x","x","x","x");
        dao.insert(test);
        test.setNumero(dao.setNumeroByCount() - 1);
        dao.delete(test);

        int expectedNumero = dao.setNumeroByCount();
        assertEquals(expectedNumero,actualNumero);

    }
}

