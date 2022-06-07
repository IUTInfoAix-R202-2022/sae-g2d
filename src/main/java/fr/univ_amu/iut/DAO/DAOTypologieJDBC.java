package fr.univ_amu.iut.DAO;

import fr.univ_amu.iut.Main;
import fr.univ_amu.iut.database.Typologie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOTypologieJDBC implements DAOTypologie {

    public static int numero;
    private final PreparedStatement insertStatement;
    private final PreparedStatement deleteStatament;
    private final PreparedStatement updateStatement;
    private final PreparedStatement findByAcademie;
    private final PreparedStatement findByThematiquesUsageGroupByAcademie;
    private final Statement findThematiquesUsage;

    private final Connection connection = Main.getDBConnection();   //On récupère la connection

    /**
     * Constructeur | Initialise tout les prepareStatement
     *
     * @throws SQLException
     */
    public DAOTypologieJDBC() throws SQLException {
        // Requête pour insérer un tuple
        insertStatement = connection.prepareStatement("INSERT INTO typologie (NUMERO, THEMATIQUE_USAGE, DISCIPLINE, DEGRE, ACADEMIE, REGION_ACADEMIQUE, TYPE_ACTEUR, IDENTITE_ACTEUR, URL_RESSOURCE, NOM_RESSOURCE, TYPE_SOURCE, COMMENTAIRES) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");

        // Requête pour supprimer un tuple
        deleteStatament = connection.prepareStatement("DELETE FROM typologie WHERE NUMERO = ?");

        // Requête pour modifier un tuple
        updateStatement = connection.prepareStatement("UPDATE typologie SET THEMATIQUE_USAGE = ?" +
                ", DISCIPLINE = ?, DEGRE = ?, ACADEMIE = ?, REGION_ACADEMIQUE = ?, TYPE_ACTEUR = ?, IDENTITE_ACTEUR = ?, URL_RESSOURCE = ?, NOM_RESSOURCE = ?, TYPE_SOURCE = ?, COMMENTAIRES = ? WHERE NUMERO = ?");

        // Requête pour trouver les tuples par rapport à une académie et les trier par thematique usage
        findByAcademie = connection.prepareStatement("SELECT * FROM typologie WHERE ACADEMIE = ? ORDER BY THEMATIQUE_USAGE");

        // Requête pour trouver les tuples par rapport à une thématique usage, et on regroupe ses tuples par rapport à leur académie
        findByThematiquesUsageGroupByAcademie = connection.prepareStatement("SELECT ACADEMIE FROM typologie WHERE THEMATIQUE_USAGE = ?");

        // Requête pour trouver toutes les thématiques usages
        findThematiquesUsage = connection.createStatement();
    }

    /**
     * On récupère le prochain numero
     * @return int
     * @throws SQLException
     */
    public int setNumeroByCount() throws SQLException {
        Statement statement = connection.createStatement();
        String reqNumero = "SELECT MAX(NUMERO) FROM typologie;";
        System.out.println("Execution de la requête : " + reqNumero);
        ResultSet rset = statement.executeQuery(reqNumero);

        while (rset.next()) {
            numero = rset.getInt(1) + 1;
        }
        //statement.close();
        return numero;
    }

    /**
     * Insérer un tuple dans la BDD
     * @return Typologie
     * @param typologie
     */
    @Override
    public Typologie insert(Typologie typologie) throws SQLException {
        insertStatement.setInt(1, setNumeroByCount());
        insertStatement.setString(2, typologie.getThematique_usage());
        insertStatement.setString(3, typologie.getDiscipline());
        insertStatement.setString(4, typologie.getDegre());
        insertStatement.setString(5, typologie.getAcademie());
        insertStatement.setString(6, typologie.getRegion_academique());
        insertStatement.setString(7, typologie.getType_acteur());
        insertStatement.setString(8, typologie.getIdentite_acteur());
        insertStatement.setString(9, typologie.getUrl_ressource());
        insertStatement.setString(10, typologie.getNom_ressource());
        insertStatement.setString(11, typologie.getType_source());
        insertStatement.setString(12, typologie.getCommentaires());

        insertStatement.executeUpdate();
        //createStatement.close();
        return typologie;

    }

    /**
     * Supprimer un tuple de la BDD
     * @return boolean
     * @param typologie
     */
    @Override
    public boolean delete(Typologie typologie) throws SQLException {
        try {
            deleteStatament.setInt(1, typologie.getNumero());
            deleteStatament.executeUpdate();
           //deleteStatament.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Modifier un tuple de la BDD
     * @return boolean
     * @param typologie
     * @throws SQLException
     */
    @Override
    public boolean update(Typologie typologie) throws SQLException {
        try {
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
            //updateStatement.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Permet d'obtenir les tuples par rapport à une académie donnée
     * @param nomAcademie
     * @return List<Typologie>
     * @throws SQLException
     */
    @Override
    public List<Typologie> findByAcademie(String nomAcademie) throws SQLException {
        List<Typologie> donneesAcademie = new ArrayList<>();
        findByAcademie.setString(1,nomAcademie);
        ResultSet resultSet = findByAcademie.executeQuery();

        while (resultSet.next()){
            Typologie typologie = new Typologie();
            typologie.setNumero(resultSet.getInt(1));
            typologie.setThematique_usage(resultSet.getString(2));
            typologie.setDiscipline(resultSet.getString(3));
            typologie.setDegre(resultSet.getString(4));
            typologie.setAcademie(resultSet.getString(5));
            typologie.setRegion_academique(resultSet.getString(6));
            typologie.setType_acteur(resultSet.getString(7));
            typologie.setIdentite_acteur(resultSet.getString(8));
            typologie.setUrl_ressource(resultSet.getString(9));
            typologie.setNom_ressource(resultSet.getString(10));
            typologie.setType_source(resultSet.getString(11));
            typologie.setCommentaires(resultSet.getString(12));
            donneesAcademie.add(typologie);
        }

        return donneesAcademie;
    }

    /**
     * Permet d'obtenir les tuples par rapport à une thématique usage donnée, et on regroupe ses tuples par rapport à leur académie
     * @param nomThematiqueUsage
     * @return List<Typologie>
     * @throws SQLException
     */
    @Override
    public List<Typologie> findByThematiquesUsageGroupByAcademie(String nomThematiqueUsage) throws SQLException {
        List<Typologie> donneesAcademie = new ArrayList<>();
        findByThematiquesUsageGroupByAcademie.setString(1,nomThematiqueUsage);
        ResultSet resultSet = findByThematiquesUsageGroupByAcademie.executeQuery();

        while (resultSet.next()){
            Typologie typologie = new Typologie();
            typologie.setAcademie(resultSet.getString(1));
            donneesAcademie.add(typologie);
        }

        return donneesAcademie;
    }

    /**
     * Permet d'obtenir toutes les thématiques usages
     * @return List<Typologie>
     * @throws SQLException
     */
    @Override
    public List<Typologie> findThematiquesUsage() throws SQLException {
        List<Typologie> donneesAcademie = new ArrayList<>();

        ResultSet resultSet = findThematiquesUsage.executeQuery("SELECT DISTINCT THEMATIQUE_USAGE FROM typologie"); // Requête pour trouver toutes les thématiques usages
        while (resultSet.next()){
            Typologie typologie = new Typologie();
            typologie.setThematique_usage(resultSet.getString(1));
            donneesAcademie.add(typologie);
        }

        //resultSet.close();
        return donneesAcademie;
    }
}
