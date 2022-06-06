package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Usage;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DAOUsageJPA extends DAOJPAImpl implements DAOUsage {
    DAOUsageJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean delete(Usage obj) {
        try {
            super.deleteImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Usage> findAll() {
        return super.findImpl(Usage.class, "Usage.findAll");
    }

    @Override
    public Usage getById(Integer id) {
        return super.getByIdImpl(Usage.class, id);
    }

    @Override
    public Usage insert(Usage obj) {
        super.insertImpl(obj);
        return getById(obj.getId());
    }

    @Override
    public boolean update(Usage obj) {
        try {
            super.updateImpl(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
