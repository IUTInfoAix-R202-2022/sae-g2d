package fr.univ_amu.iut.database;

import fr.univ_amu.iut.HelloApplication;

import java.sql.*;

public class DAOTypologieJDBC {


    public static int numero;
    private final PreparedStatement createStatement;
    private final PreparedStatement deleteStatament;

    private final Connection connection = HelloApplication.getDBConnection();   //On récupère la connection

    /**
     * Constructeur
     *
     * @throws SQLException
     */
    public DAOTypologieJDBC() throws SQLException {
        createStatement = connection.prepareStatement("INSERT INTO typologie (NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);      //On prépare la requête pour insérer un tuple
        deleteStatament = connection.prepareStatement("DELETE FROM typologie WHERE " +
                "THEMATIQUE_USAGE=? AND DISCIPLINE=? AND DEGRE=? AND ACADEMIE=? AND" +
                "REGION_ACADEMIQUE=? AND TYPE_ACTEUR=? AND IDENTITE_ACTEUR=? AND " +
                "URL_RESSOURCE=? AND TYPE_SOURCE=? AND COMMENTAIRES=?");
    }

    /**
     * On récupère le prochain numero
     *
     * @throws SQLException
     */
    public int setNumeroByCount() throws SQLException {
        Statement statement = connection.createStatement();
        String reqNumero = "SELECT COUNT(*) FROM typologie;";
        System.out.println("Execution de la requête : " + reqNumero );
        ResultSet rset = statement.executeQuery(reqNumero);

        while(rset.next()){
            numero = rset.getInt(1) + 1;
        }
        statement.close();
        return numero;
    }

    /**
     * Insérer un tuple dans la BDD
     *
     * @param typologie
     */
    public void insert(Typologie typologie){
        try{
            createStatement.setInt(1,setNumeroByCount());
            createStatement.setString(2,typologie.getThematique_usage());
            createStatement.setString(3,typologie.getDiscipline());
            createStatement.setString(4,typologie.getDegre());
            createStatement.setString(5,typologie.getAcademie());
            createStatement.setString(6,typologie.getRegion_academique());
            createStatement.setString(7,typologie.getType_acteur());
            createStatement.setString(8,typologie.getIdentite_acteur());
            createStatement.setString(9,typologie.getUrl_ressource());
            createStatement.setString(10,typologie.getNom_ressource());
            createStatement.setString(11,typologie.getType_source());
            createStatement.setString(12,typologie.getCommentaires());

            createStatement.executeUpdate();
            createStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Supprimer un tuple de la BDD
     *
     * @param typologie
     */
    public void delete(Typologie typologie){

    }
}
