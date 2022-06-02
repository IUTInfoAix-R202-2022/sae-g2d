package fr.univ_amu.iut;

import fr.univ_amu.iut.database.DAOTypologieJDBC;
import fr.univ_amu.iut.database.Typologie;
import fr.univ_amu.iut.view.map.AcademiePath;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AcademieController {

    private SceneController sceneController = new SceneController();
    private DAOTypologieJDBC dao = new DAOTypologieJDBC();

    private Jdbc jdbc = new Jdbc();

    private AcademiePath academiePath;

    @FXML
    private GridPane gridPane;

    public AcademieController() throws SQLException {
    }

    @FXML
    public void switchTo() throws IOException {
        sceneController.switchTo2(gridPane,"carte.fxml");
    }

    @FXML
    public void initialize() throws SQLException {
        academiePath = jdbc.getAcademiePath();
        System.out.println(academiePath.getAcademie().getNom());
        List<Typologie> donneesAcademie = dao.findByAcademie(academiePath.getAcademie().getNom());
        System.out.println(donneesAcademie.size());
        for (Typologie t : donneesAcademie){
            System.out.println(t);
        }


    }


}

