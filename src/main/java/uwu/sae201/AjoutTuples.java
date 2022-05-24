package uwu.sae201;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.List;

public class AjoutTuples {

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

    private List<TextField> textFieldList;

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

       } catch (SQLException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void ajout(){
        System.out.println("action de la requête en cours");

        try {
            req = "INSERT INTO typologie (NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);"
            ;

            System.out.println("test");
            preparedStatement = connection.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, numero);
            preparedStatement.setString(2, String.valueOf("2"));
            preparedStatement.setString(3, String.valueOf(discipline.getText()));
            preparedStatement.setString(4, String.valueOf(degre.getText()));
            preparedStatement.setString(5, String.valueOf(academie.getText()));
            preparedStatement.setString(6, String.valueOf("6"));
            preparedStatement.setString(7, String.valueOf("7"));
            preparedStatement.setString(8, String.valueOf("8"));
            preparedStatement.setString(9, String.valueOf(url_ressource.getText()));
            preparedStatement.setString(10, String.valueOf("10"));
            preparedStatement.setString(11, String.valueOf(type_source.getText()));
            preparedStatement.setString(12, String.valueOf("12"));
            ++this.numero;
            System.out.println(numero);

            System.out.println("before");
            preparedStatement.executeUpdate();
            System.out.println("after");

            System.out.println("requête envoyée");

        } catch (SQLException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }



        System.out.println("fin de la requête");

    }
    private void supression(){
        req = "DELETE FROM typologie WHERE (";
    }
}
