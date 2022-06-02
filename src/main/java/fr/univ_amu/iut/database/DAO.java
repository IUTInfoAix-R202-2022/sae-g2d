package fr.univ_amu.iut.database;

import java.sql.SQLException;

public interface DAO {

    void insert(Typologie typologie) throws SQLException;
    void delete(Typologie typologie) throws SQLException;
    void update(Typologie typologie) throws SQLException;

}
