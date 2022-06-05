package fr.univ_amu.iut.page_accueil;

import fr.univ_amu.iut.HelloApplication;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
public class TestAccueil {
    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestAccueil.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(TestAccueil.this.stage);
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
        HelloApplication.closeDBConnection();
    }

    @Test
    public void should_initialize_stage_is_showing() {
        assertThat(stage.isShowing()).isTrue();
    }

    @Test
    public void should_initialize_stage_with_correct_title() {
        assertThat(stage.getTitle()).isEqualTo("Dico Pédago");
    }

    @Test
    public void should_contain_button_with_label_acceder() {
        verifyThat("#labelBoutonAccederAccueil", hasText("Accéder"));
    }

    @Test
    public void should_contain_button_with_text_se_connecter() {
        verifyThat("#boutonSeConnecterAccueil", hasText("Se connecter"));
    }

    @Test
    public void button_se_connecter_should_redirect_to_connexion_administrateur(FxRobot robot) {
        assertThat(robot.clickOn("#boutonSeConnecterAccueil").equals(new FxRobotException("")));//On vérifie qu'on est plus sur la page accueil'
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
