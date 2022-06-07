package fr.univ_amu.iut.connexion_admin;

import fr.univ_amu.iut.Main;
import fr.univ_amu.iut.SceneController;
import fr.univ_amu.iut.DAO.DAOUtilisateurJDBC;
import fr.univ_amu.iut.database.Utilisateur;
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

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
public class TestConnexionAdmin {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestConnexionAdmin.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new Main().start(TestConnexionAdmin.this.stage);
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
    public void should_initialize_correct_page_with_correct_label(FxRobot robot) {
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#labelIdentifiant", hasText("IDENTIFIANT"));
    }

    @Test
    public void should_contain_label_mot_de_passe(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#labelMotDePasseAdmin", hasText("MOT DE PASSE"));
    }
    @Test
    public void should_initialize_with_correct_label_annuler(FxRobot robot) {
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#labelAnnuler", hasText("Annuler"));
    }

    @Test
    public void should_initialize_with_correct_labe_seconnecter(FxRobot robot) {
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#labelConnecter", hasText("Se connecter"));
    }

    @Test
    public void should_initialize_textField_with_no_text(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#identifiant", hasText(""));
    }

    @Test
    public void should_initialize_passwordField_with_no_text(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        verifyThat("#motDePasse", hasText(""));
    }

    @Test
    public void should_connect_admin(FxRobot robot) {
        robot.clickOn("#boutonSeConnecterAccueil");
        assertEquals(SceneController.getData(), "fxml/connexion_administrateur.fxml");
    }
}
