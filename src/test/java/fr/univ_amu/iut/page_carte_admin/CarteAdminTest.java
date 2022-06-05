package fr.univ_amu.iut.page_carte_admin;

import fr.univ_amu.iut.HelloApplication;
import fr.univ_amu.iut.SceneController;
import fr.univ_amu.iut.database.DAOTypologieJDBC;
import fr.univ_amu.iut.database.Typologie;
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
public class CarteAdminTest {
    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            fr.univ_amu.iut.page_carte_admin.CarteAdminTest.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(fr.univ_amu.iut.page_carte_admin.CarteAdminTest.this.stage);
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
    public void should_initialize_stage_is_showing(FxRobot robot) {
        robot.clickOn("#boutonSeConnecterAccueil");
        assertThat(stage.isShowing()).isTrue();
    }

    @Test
    public void should_initialize_window_with_correct_title(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        assertThat(stage.getTitle().equals("Dico Pédago"));
    }

    @Test
    public void should_initialize_height_of_window_to_720(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        assertThat(stage.getScene().getHeight() == 720);
    }

    @Test
    public void should_initialize_width_of_window_to_1280(FxRobot robot){
        robot.clickOn("#boutonSeConnecterAccueil");
        assertThat(stage.getScene().getWidth() == 1280);
    }


    @Test
    public void should_intialize_vbox_with_usage_in_the_database(FxRobot robot) throws SQLException {
        robot.clickOn("#boutonSeConnecterAccueil");
        DAOTypologieJDBC dao = new DAOTypologieJDBC();
        Typologie typologie = new Typologie(10, "a", "a", "a","a","a","a","a","a","a","a","a");
        dao.insert(typologie);

        assertThat(dao.findThematiquesUsage().contains(typologie.getThematique_usage()));

        typologie.setNumero(dao.setNumeroByCount() - 1);
        dao.delete(typologie);
    }

    @Test
    public void should_not_have_academie_for_this_thematique_usage(FxRobot robot) throws SQLException {
        robot.clickOn("#boutonSeConnecterAccueil");
        DAOTypologieJDBC dao = new DAOTypologieJDBC();
        List<Typologie> ActualfindByThematiquesUsageGroupByAcademie = dao.findByThematiquesUsageGroupByAcademie("a");
        assertEquals(ActualfindByThematiquesUsageGroupByAcademie.size(),0);
    }

     /*
    @Test
    public void should_have_button_configurer() {
        robot.clickOn
        verifyThat("#labelButtonConfigureCarteAdmin", hasText("Configurer"));}
     */

}
