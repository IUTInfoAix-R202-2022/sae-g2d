package fr.univ_amu.iut;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(ApplicationExtension.class)
public class TestHelloApplication {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestHelloApplication.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(TestHelloApplication.this.stage);
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
    public void should_initialize_bdd() {
        assertNotEquals(HelloApplication.getDBConnection(),null);
    }

    @Test
    public void should_initialize_DAOTypologie() {
        assertNotEquals(HelloApplication.getDaoTypologieJDBC(),null);
    }
    @Test
    public void should_initialize_DAOUtilisateur() {
        assertNotEquals(HelloApplication.getDaoUtilisateurJDBC(),null);
    }


}
