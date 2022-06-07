package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.view.map.AcademiePath;
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

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.isVisible;

@ExtendWith(ApplicationExtension.class)
public class TestParcoursUtilisateur1 {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestParcoursUtilisateur1.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(TestParcoursUtilisateur1.this.stage);
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
    void should_open_the_carte(FxRobot robot){
        robot.clickOn("#boutonAccederAccueil");
        assertEquals(SceneController.getData(), "fxml/carte.fxml");
        verifyThat("#gridpane", isVisible());
    }

    @Test
    void should_open_the_description_of_the_usage(FxRobot robot){
        robot.clickOn("#boutonAccederAccueil");
        AcademiePath.get(Academie.Poitiers).setId("poitier");
        robot.clickOn("#poitier");
        verifyThat("#academie_selectionne", isVisible());
    }
    @Test
    void should_close_the_description_of_the_usage_and_return_to_accueil(FxRobot robot){
        robot.clickOn("#boutonAccederAccueil");
        AcademiePath.get(Academie.Poitiers).setId("poitier");
        robot.clickOn("#poitier");
        robot.clickOn("#fermer");
        robot.clickOn("#fermer");
        verifyThat("#labelBienvenue", isVisible());
    }

}
