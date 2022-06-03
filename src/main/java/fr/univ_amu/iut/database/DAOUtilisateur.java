package fr.univ_amu.iut.database;

import java.sql.SQLException;
import java.util.List;

public interface DAOUtilisateur extends DAO<Utilisateur, String>{
    List<Utilisateur> findAll() throws SQLException;
}
