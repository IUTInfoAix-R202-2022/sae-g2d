package fr.univ_amu.iut.connexion_admin;

import fr.univ_amu.iut.HelloApplication;
import fr.univ_amu.iut.SceneController;
import fr.univ_amu.iut.database.DAOUtilisateurJDBC;
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
                        new HelloApplication().start(TestConnexionAdmin.this.stage);
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
