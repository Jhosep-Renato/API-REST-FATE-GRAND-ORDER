package com.japrova.fategrandorder.dao;

import com.japrova.fategrandorder.entity.Servant;

import java.util.Optional;

public interface FateGoDao {

    Optional<Servant> findServantByName(String nameServant);

    void saveServantClass(int idClass, int idServant);

    void saveServanTypes(int idLetter, int idServant);

    int findServantType(int id);
    int findServantClass(int idServant);

}
