package fr.univ_amu.iut.database;

import fr.univ_amu.iut.HelloApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOTypologieJDBC implements DAOTypologie {

    public static int numero;
    private final PreparedStatement createStatement;
    private final PreparedStatement deleteStatament;
    private final PreparedStatement updateStatement;
    private final PreparedStatement findByAcademie;
    private final PreparedStatement findByThematiquesUsageGroupByAcademie;

    private final Connection connection = HelloApplication.getDBConnection();   //On récupère la connection

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
        findByAcademie = connection.prepareStatement("SELECT * FROM typologie WHERE ACADEMIE = ?");
        findByThematiquesUsageGroupByAcademie = connection.prepareStatement("SELECT ACADEMIE FROM typologie WHERE THEMATIQUE_USAGE = ?");
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
}
