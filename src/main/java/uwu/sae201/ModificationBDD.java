package uwu.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModificationBDD {

    private static int numero;

    @FXML
    private TextField thematique_usage;
    @FXML
    private TextField discipline;
    @FXML
    private TextField degre;
    @FXML
    private TextField academie;
    @FXML
    private TextField region_academique;
    @FXML
    private TextField type_acteur;
    @FXML
    private TextField identite_acteur;
    @FXML
    private TextField url_ressource;
    @FXML
    private TextField nom_ressource;
    @FXML
    private TextField type_source;
    @FXML
    private TextField commentaires;

    private List<TextField> textFieldList = new ArrayList<>();
    private List<String> stringUsageList = new ArrayList<>();

    private Connection connection = Database.getDBConnection();
    private PreparedStatement preparedStatement;
    private Statement statement;
    private String req;


    @FXML
    public void initialize() {
        try {
            statement = connection.createStatement();

            String reqNumero = "SELECT COUNT(*) FROM typologie;";

            System.out.println("Execution de la requête : " + reqNumero );
            ResultSet rset = statement.executeQuery(reqNumero);

            while(rset.next()){
                numero = rset.getInt(1) + 1;
            }

            textFieldList.add(thematique_usage);
            textFieldList.add(discipline);
            textFieldList.add(degre);
            textFieldList.add(academie);
            textFieldList.add(region_academique);
            textFieldList.add(type_acteur);
            textFieldList.add(identite_acteur);
            textFieldList.add(url_ressource);
            textFieldList.add(nom_ressource);
            textFieldList.add(type_source);
            textFieldList.add(commentaires);

            stringUsageList.add("THEMATIQUE_USAGE");
            stringUsageList.add("DISCIPLINE");
            stringUsageList.add("DEGRE");
            stringUsageList.add("ACADEMIE");
            stringUsageList.add("REGION_ACADEMIQUE");
            stringUsageList.add("TYPE_ACTEUR");
            stringUsageList.add("IDENTITE_ACTEUR");
            stringUsageList.add("URL_RESSOURCE");
            stringUsageList.add("NOM_RESSOURCE");
            stringUsageList.add("TYPE_SOURCE");
            stringUsageList.add("COMMENTAIRES");


       } catch (SQLException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void verificationDesLabels(){
        for (TextField l : textFieldList){
            if (l.getText().isEmpty()){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Exécution de la requête SQL Impossible");
                errorAlert.setContentText("Tous les champs doivent être remplis");
                errorAlert.showAndWait();
                return;
            }
        }
        ajout();
    }

    private void ajout(){
        System.out.println("action de la requête en cours");

        try {
            req = "INSERT INTO typologie (NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);"
            ;

            preparedStatement = connection.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, numero);
            preparedStatement.setString(2, String.valueOf(thematique_usage.getText()));
            preparedStatement.setString(3, String.valueOf(discipline.getText()));
            preparedStatement.setString(4, String.valueOf(degre.getText()));
            preparedStatement.setString(5, String.valueOf(academie.getText()));
            preparedStatement.setString(6, String.valueOf(region_academique.getText()));
            preparedStatement.setString(7, String.valueOf(type_acteur.getText()));
            preparedStatement.setString(8, String.valueOf(identite_acteur.getText()));
            preparedStatement.setString(9, String.valueOf(url_ressource.getText()));
            preparedStatement.setString(10, String.valueOf(nom_ressource.getText()));
            preparedStatement.setString(11, String.valueOf(type_source.getText()));
            preparedStatement.setString(12, String.valueOf(commentaires.getText()));

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Exécution de la requête SQL en cours");
            alert.setContentText("Voulez-vous vraiment ajouter ces tuples dans la base de données");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                preparedStatement.executeUpdate();
                System.out.println("requête envoyée");
                ++this.numero;

            } else {
                System.out.println("requête annulée");
            }

        } catch (SQLException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void suppression(){
        try {
            req = "DELETE FROM typologie WHERE (";

            for (int i = 0; i < textFieldList.size(); ++i) {
                if (!(textFieldList.get(i).getText().isEmpty())) {
                    req += stringUsageList.get(i) + " = " + textFieldList.get(i).getText() + ", ";
                }
            }
            req += ")";

            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.executeUpdate();

            System.out.println("requête envoyée");

        } catch (SQLException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }
    }
}
