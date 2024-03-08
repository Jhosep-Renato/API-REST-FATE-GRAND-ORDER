package com.japrova.fategrandorder.dao;

import com.japrova.fategrandorder.entity.Classes;
import com.japrova.fategrandorder.entity.LettersTypes;
import com.japrova.fategrandorder.entity.Servant;
import com.japrova.fategrandorder.exceptions.ServantNotFound;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ServantRepository implements ServantDao {

    private EntityManager entityManager;
    @Autowired
    public ServantRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Servant> findAllServants() throws ServantNotFound {

        String sql = "FROM Servant";

        List<Servant> servantList = (List<Servant>) findRandomData(sql, entityManager, new Servant());

        return servantList;
    }

    public Optional<Servant> findServantByName(String name) {

        String sql = "FROM Servant WHERE nameServant = :nameParam";

        TypedQuery<Servant> servantTypedQuery = entityManager
                .createQuery(sql, Servant.class);

        servantTypedQuery.setParameter("nameParam", name);

        Servant undecidedServant = null;

        try {

            undecidedServant = servantTypedQuery.getSingleResult();

        } catch (NoResultException ignored) {
        }

        return Optional.ofNullable(undecidedServant);
    }

    @Override
    public List<Classes> findAllClasses() {

        String sql = "FROM Classes";

        List<Classes> classesList = (List<Classes>) findRandomData(sql, entityManager, new Classes());

        return classesList;
    }

    @Override
    public List<LettersTypes> findAllLetters() {

        String sql = "FROM LettersTypes";

        List<LettersTypes> typesList = (List<LettersTypes>) findRandomData(sql, entityManager, new LettersTypes());

        return typesList;
    }
}