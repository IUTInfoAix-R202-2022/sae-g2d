package fr.univ_amu.iut.database;

import jakarta.persistence.Entity;

import java.sql.SQLException;

public interface DAO<Entity, Key> {

    Entity insert(Entity obj) throws SQLException;
    boolean delete(Entity obj) throws SQLException;
    boolean update(Entity obj) throws SQLException;

}
