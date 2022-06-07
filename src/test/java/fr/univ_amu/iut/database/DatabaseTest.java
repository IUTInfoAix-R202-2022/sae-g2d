
package fr.univ_amu.iut.database;

import fr.univ_amu.iut.DAO.DAOTypologieJDBC;
import fr.univ_amu.iut.DAO.DAOUtilisateurJDBC;
import fr.univ_amu.iut.Main;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
                        new Main().start(DatabaseTest.this.stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
    }

    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
        Main.closeDBConnection();
    }

    @Test
    public void should_initialize_bdd_link() {
        Connection connection = Main.getDBConnection();
        assertNotEquals(connection,null);

    }
    @Test
    public void should_add_tuple_in_bdd() throws SQLException {
        DAOTypologieJDBC dao = new DAOTypologieJDBC();
        Typologie test = new Typologie(1,"x","x","x","x","x","x","x","x","x","x","x");
        assertEquals(dao.insert(test),test);

        test.setNumero(dao.setNumeroByCount() - 1);
        dao.delete(test);
    }

   @Test
    public void should_delete_tuple_in_bdd() throws SQLException {
        DAOTypologieJDBC dao = new DAOTypologieJDBC();
        int actualNumero = dao.setNumeroByCount();

        Typologie test = new Typologie(1,"x","x","x","x","x","x","x","x","x","x","x");
        dao.insert(test);
        test.setNumero(dao.setNumeroByCount() - 1);
        dao.delete(test);

        int expectedNumero = dao.setNumeroByCount();
        assertEquals(expectedNumero,actualNumero);
    }

    @Test
    public void should_get_password_and_login_from_bdd() throws SQLException {
        //Récupération de l'identidiant et du mot de passe dans la bdd
        DAOUtilisateurJDBC dao = new DAOUtilisateurJDBC();
        List<Utilisateur> utilisateurBDD = dao.findAll();
        String idBDD = utilisateurBDD.get(0).getID();
        String mdpBDD = utilisateurBDD.get(0).getMotDePasse();

        //Comparaison
        assertEquals(idBDD, "c3a7f1359ce25b31dc601b8fa0ea3a62ec90abbe89dc0628f8706821baed2759d56de24ac8072c3b12dd46bfa313d937c9e062cd450a3c55168324bd6f857233");
        assertEquals(mdpBDD, "117a0202c08f4723df863b52bcb93237742914e5e2fe297d4059e44fd6aa506ba3bb9d00fa4fefd09952f23f6ac816399ea67e24577fb5a7997593944ff0ffc");
    }
}

