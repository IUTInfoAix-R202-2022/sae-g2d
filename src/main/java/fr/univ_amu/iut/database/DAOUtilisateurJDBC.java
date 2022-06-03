package fr.univ_amu.iut.database;

import fr.univ_amu.iut.HelloApplication;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUtilisateurJDBC implements DAOUtilisateur{

    private final Connection connection = HelloApplication.getDBConnection();
    private final PreparedStatement findAllStatement;

    /**
     * Constructeur
     *
     * @throws SQLException
     */
    public DAOUtilisateurJDBC() throws SQLException {
        findAllStatement = connection.prepareStatement("SELECT * FROM utilisateur");
    }

    /**
     * Renvoie tous les utilisateurs
     * @return List<Utilisateur>
     * @throws SQLException
     */
    @Override
    public List<Utilisateur> findAll() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        ResultSet resultSet = findAllStatement.executeQuery();

        while(resultSet.next()) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setID(resultSet.getString(1));
            utilisateur.setMotDePasse(resultSet.getString(2));
            utilisateurs.add(utilisateur);
        }
        return utilisateurs;
    }

    @Override
    public Utilisateur insert(Utilisateur obj) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Utilisateur obj) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Utilisateur obj) throws SQLException {
        return false;
    }
}
