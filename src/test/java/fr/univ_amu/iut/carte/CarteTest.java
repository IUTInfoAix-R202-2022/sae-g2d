package fr.univ_amu.iut.carte;

import fr.univ_amu.iut.HelloApplication;
import fr.univ_amu.iut.Jdbc;
import fr.univ_amu.iut.database.DAOTypologieJDBC;
import fr.univ_amu.iut.database.DatabaseTest;
import fr.univ_amu.iut.database.Typologie;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.view.map.France;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class CarteTest {
    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            CarteTest.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloApplication().start(CarteTest.this.stage);
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
    }

    @Disabled
    @Test
    public void should_initialize_window_with_correct_title(){
        assertThat(stage.getTitle().equals("Dico Pédago"));
    }

    @Disabled
    @Test
    public void should_initialize_height_of_window_to_720(){
        assertThat(stage.getScene().getHeight() == 720);
    }

    @Disabled
    @Test
    public void should_initialize_width_of_window_to_1280(){
        assertThat(stage.getScene().getWidth() == 1280);
    }

    /*
    @Disabled
    @Test
    public void should_intialize_vbox_with_usage_in_the_database() throws SQLException {
        DAOTypologieJDBC daoTypologieJDBC = new DAOTypologieJDBC();
        Typologie typologie = new Typologie(10, "a", "a", "a","a","a","a","a","a","a","a","a");
        daoTypologieJDBC.insert(typologie);

        assertThat(daoTypologieJDBC.findThematiquesUsage().contains(typologie));
        daoTypologieJDBC.delete(typologie);
    }

    @Disabled
    @Test
    public void should_initialize_carte_with_correct_color() throws SQLException {
        France france;
        DAOTypologieJDBC daoTypologieJDBC = new DAOTypologieJDBC();
        Typologie typologie = new Typologie(10, "a", "a", "a","a","a","a","a","a","a","a","a");
        typologie.setAcademie(Academie.AixMarseille.toString());
        List<Typologie> typologieList = new ArrayList<>();
        typologieList.add(typologie);

        Jdbc jdbc = new Jdbc();
        jdbc.initializeColorsOfCarte(typologieList);
        daoTypologieJDBC.delete(typologie);

    }
    */
}
