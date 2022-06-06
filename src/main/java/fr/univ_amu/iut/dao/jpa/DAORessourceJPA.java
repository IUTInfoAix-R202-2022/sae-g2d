package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.model.Ressource;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAORessourceJPA extends DAOJPAImpl implements DAORessource {
    DAORessourceJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(Ressource obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Ressource> findAll() {
        return super.findImpl(Ressource.class, "Ressource.findAll");
    }

    @Override
    public Ressource getById(Integer id) {
        return super.getByIdImpl(Ressource.class, id);
    }

    @Override
    public Ressource insert(Ressource obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(Ressource obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
