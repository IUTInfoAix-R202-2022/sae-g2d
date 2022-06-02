package fr.univ_amu.iut.database;

import java.sql.SQLException;
import java.util.List;

public interface DAOTypologie extends DAO{

    List<Typologie> findByAcademie(String nomAcademie) throws SQLException;
    List<Typologie> findByThematiquesUsageGroupByAcademie(String nomThematiqueUsage) throws SQLException;

}
