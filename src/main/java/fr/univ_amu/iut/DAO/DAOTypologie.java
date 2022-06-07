package fr.univ_amu.iut.DAO;

import fr.univ_amu.iut.database.Typologie;

import java.sql.SQLException;
import java.util.List;

public interface DAOTypologie extends DAO<Typologie, Integer> {

    /**
     * On récupère le prochain numero
     * @return int
     * @throws SQLException
     */
    int setNumeroByCount() throws SQLException;

    /**
     * Permet d'obtenir les tuples par rapport à une académie donnée
     * @param nomAcademie
     * @return List<Typologie>
     * @throws SQLException
     */
    List<Typologie> findByAcademie(String nomAcademie) throws SQLException;

    /**
     * Permet d'obtenir les tuples par rapport à une thématique usage donnée, et on regroupe ses tuples par rapport à leur académie
     * @param nomThematiqueUsage
     * @return List<Typologie>
     * @throws SQLException
     */
    List<Typologie> findByThematiquesUsageGroupByAcademie(String nomThematiqueUsage) throws SQLException;

    /**
     * Permet d'obtenir toutes les thématiques usages
     * @return List<Typologie>
     * @throws SQLException
     */
    List<Typologie> findThematiquesUsage() throws SQLException;

}
