package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.view.map.AcademiePath;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;
import static org.testfx.util.NodeQueryUtils.isVisible;

@ExtendWith(ApplicationExtension.class)
public class TestParcoursUtilisateur2 {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestParcoursUtilisateur2.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(TestParcoursUtilisateur2.this.stage);
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
    void should_open_the_application(){
        assertEquals(stage.isShowing(), true);
    }

    @Test
    void should_try_to_connect_admin_but_not_work(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#labelIdentifiant", hasText("IDENTIFIANT"));
        verifyThat("#labelMotDePasseAdmin", hasText("MOT DE PASSE"));
    }

    @Test
    void should_return_to_accueil_and_go_to_carte(FxRobot robot){
        robot.clickOn("#labelBoutonAccederAccueil");
        assertEquals(SceneController.getData(), "fxml/carte.fxml");
        verifyThat("#gridpane", isVisible());
    }

    @Test
    void should_open_the_usage_of_academie(FxRobot robot){
        robot.clickOn("#labelBoutonAccederAccueil");
        AcademiePath.get(Academie.Creteil).setId("cretiel");
        robot.clickOn("#cretiel");
        verifyThat("#academie_selectionne", hasText(Academie.Creteil.getNom()));
    }
    @Test
    void should_realize_all_actions(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#labelIdentifiant", hasText("IDENTIFIANT"));
        verifyThat("#labelMotDePasseAdmin", hasText("MOT DE PASSE"));
        robot.clickOn("#buttonCancel");
        robot.clickOn("#labelBoutonAccederAccueil");
        assertEquals(SceneController.getData(), "fxml/carte.fxml");
        AcademiePath.get(Academie.Creteil).setId("creteil");
        robot.clickOn("#creteil");
        verifyThat("#academie_selectionne", hasText(Academie.Creteil.getNom()));
        robot.clickOn("#fermer");
        robot.clickOn("#fermer");
        verifyThat("#labelBienvenue", isVisible());
    }
}
