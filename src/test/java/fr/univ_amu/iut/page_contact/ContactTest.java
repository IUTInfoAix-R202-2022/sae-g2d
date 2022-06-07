package fr.univ_amu.iut.page_contact;

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

import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;
import static org.testfx.util.NodeQueryUtils.isVisible;

@ExtendWith(ApplicationExtension.class)
public class ContactTest {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            ContactTest.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new Main().start(ContactTest.this.stage);
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
    void should_initialize_contact_page(FxRobot robot){
        robot.clickOn("#boutonContactAccueil");
        verifyThat("#label", hasText("Pour toute demande d'ajout, de modification ou d'aide n'hésitez pas à nous contacter !"));
    }

    @Test
    void should_initialize_contact_page_with_two_label_contacter_and_annuler(FxRobot robot){
        robot.clickOn("#boutonContactAccueil");
        verifyThat("#labelContact", hasText("Contacter"));
        verifyThat("#labelCancel", hasText("Annuler"));
    }

    @Test
    void should_return_to_home_page(FxRobot robot){
        robot.clickOn("#boutonContactAccueil");
        robot.clickOn("#buttonCancel");
        verifyThat("#labelBienvenue", isVisible());
    }
}
