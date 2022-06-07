package fr.univ_amu.iut.academie;

import fr.univ_amu.iut.Main;
import fr.univ_amu.iut.DAO.DAOTypologieJDBC;
import fr.univ_amu.iut.database.Typologie;
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

import java.sql.*;
import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasChildren;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
public class TestAcademie {
    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestAcademie.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new Main().start(TestAcademie.this.stage);
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
    public void should_label_of_academie_page_selected_have_correct_name(FxRobot robot) {
        robot.clickOn("#boutonAccederAccueil");
        AcademiePath academiePath = AcademiePath.get(Academie.Nice);
        academiePath.setId("nice");
        robot.clickOn("#nice");
        verifyThat("#academie_selectionne", hasText(Academie.Nice.getNom()));
    }

    @Test
    public void should_label_of_poitier_academie_page_selected_have_correct_name(FxRobot robot) {
        robot.clickOn("#boutonAccederAccueil");
        AcademiePath academiePath = AcademiePath.get(Academie.Poitiers);
        academiePath.setId("poitier");
        robot.clickOn("#poitier");
        verifyThat("#academie_selectionne", hasText(Academie.Poitiers.getNom()));
    }

    @Test
    public void should_label_of_aix_marseille_academie_page_selected_have_correct_name(FxRobot robot) {
        robot.clickOn("#boutonAccederAccueil");
        AcademiePath academiePath = AcademiePath.get(Academie.AixMarseille);
        academiePath.setId("aix");
        robot.clickOn("#aix");
        verifyThat("#academie_selectionne", hasText(Academie.AixMarseille.getNom()));
    }

    @Test
    public void should_initialize_number_of_hbox_of_aix_marseille_academine_page_selected_have_correct_number(FxRobot robot) throws SQLException {
        DAOTypologieJDBC daoTypologieJDBC = new DAOTypologieJDBC();
        int nombreDeHbox = daoTypologieJDBC.findByAcademie(Academie.AixMarseille.getNom()).size();
        robot.clickOn("#boutonAccederAccueil");
        AcademiePath academiePath = AcademiePath.get(Academie.AixMarseille);
        academiePath.setId("aix");
        robot.clickOn("#aix");
        verifyThat("#anchorPane_academie", hasChildren(1 + nombreDeHbox, "#hbox_academie"));
    }

    @Test
    public void should_increase_number_of_hbox_of_aix_marseille_academie_page_selected_have_correct_number(FxRobot robot) throws SQLException {
        DAOTypologieJDBC daoTypologieJDBC = new DAOTypologieJDBC();
        int nombreDeHbox = daoTypologieJDBC.findByAcademie(Academie.AixMarseille.getNom()).size();

        Typologie typologie = new Typologie(10, "a", "a", "a","a","a","a","a","a","a","a","a");
        typologie.setAcademie(Academie.AixMarseille.getNom());
        daoTypologieJDBC.insert(typologie);

        robot.clickOn("#boutonAccederAccueil");
        AcademiePath academiePath = AcademiePath.get(Academie.AixMarseille);
        academiePath.setId("aix");
        robot.clickOn("#aix");
        verifyThat("#anchorPane_academie", hasChildren(1 + nombreDeHbox + 1, "#hbox_academie"));
        typologie.setNumero(daoTypologieJDBC.setNumeroByCount() - 1);
        daoTypologieJDBC.delete(typologie);
    }
}
