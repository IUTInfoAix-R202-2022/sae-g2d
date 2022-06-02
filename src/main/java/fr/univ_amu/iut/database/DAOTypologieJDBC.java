package fr.univ_amu.iut.database;

import java.sql.*;

public class DAOTypologieJDBC implements DAO {

    public static int numero;
    private final PreparedStatement createStatement;
    private final PreparedStatement deleteStatament;
    private final PreparedStatement updateStatement;

    private final Connection connection = Database.getDBConnection();   //On récupère la connection

    /**
     * Constructeur
     *
     * @throws SQLException
     */
    public DAOTypologieJDBC() throws SQLException {
        System.out.println(connection);
        createStatement = connection.prepareStatement("INSERT INTO typologie (NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);      //On prépare la requête pour insérer un tuple
        deleteStatament = connection.prepareStatement("DELETE FROM typologie WHERE NUMERO = ?");
        updateStatement = connection.prepareStatement("UPDATE typologie SET THEMATIQUE_USAGE = ?" +
                ", DISCIPLINE = ?, DEGRE = ?, ACADEMIE = ?, REGION_ACADEMIQUE = ?, TYPE_ACTEUR = ?, IDENTITE_ACTEUR = ?, URL_RESSOURCE = ?, NOM_RESSOURCE = ?, TYPE_SOURCE = ?, COMMENTAIRES = ? WHERE NUMERO = ?");
    }

    /**
     * On récupère le prochain numero;
     *
     * @throws SQLException
     */
    public int setNumeroByCount() throws SQLException {
        Statement statement = connection.createStatement();
        String reqNumero = "SELECT COUNT(*) FROM typologie;";
        System.out.println("Execution de la requête : " + reqNumero);
        ResultSet rset = statement.executeQuery(reqNumero);

        while (rset.next()) {
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
    public void insert(Typologie typologie) throws SQLException {
        createStatement.setInt(1, setNumeroByCount());
        createStatement.setString(2, typologie.getThematique_usage());
        createStatement.setString(3, typologie.getDiscipline());
        createStatement.setString(4, typologie.getDegre());
        createStatement.setString(5, typologie.getAcademie());
        createStatement.setString(6, typologie.getRegion_academique());
        createStatement.setString(7, typologie.getType_acteur());
        createStatement.setString(8, typologie.getIdentite_acteur());
        createStatement.setString(9, typologie.getUrl_ressource());
        createStatement.setString(10, typologie.getNom_ressource());
        createStatement.setString(11, typologie.getType_source());
        createStatement.setString(12, typologie.getCommentaires());

        createStatement.executeUpdate();
        createStatement.close();

    }

    /**
     * Supprimer un tuple de la BDD
     *
     * @param typologie
     */
    public void delete(Typologie typologie) throws SQLException {
        deleteStatament.setInt(1, typologie.getNumero());
        deleteStatament.executeUpdate();
        deleteStatament.close();
    }

    /**
     * Modifier un tuple de la BDD
     *
     * @param typologie
     * @throws SQLException
     */
    public void update(Typologie typologie) throws SQLException {
        updateStatement.setString(1, typologie.getThematique_usage());
        updateStatement.setString(2, typologie.getDiscipline());
        updateStatement.setString(3, typologie.getDegre());
        updateStatement.setString(4, typologie.getAcademie());
        updateStatement.setString(5, typologie.getRegion_academique());
        updateStatement.setString(6, typologie.getType_acteur());
        updateStatement.setString(7, typologie.getIdentite_acteur());
        updateStatement.setString(8, typologie.getUrl_ressource());
        updateStatement.setString(9, typologie.getNom_ressource());
        updateStatement.setString(10, typologie.getType_source());
        updateStatement.setString(11, typologie.getCommentaires());
        updateStatement.setInt(12, typologie.getNumero());
        updateStatement.executeUpdate();
        updateStatement.close();
    }
}
