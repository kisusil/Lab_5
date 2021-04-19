package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.Collection;

public interface Repository {
    void add(HumanBeing humanBeing);
    void delete(int id) throws RepositoryException;
    void deleteAll();
    HumanBeing get(int id);
    Collection<HumanBeing> getAll();
    CollectionInfo getInfo();
}
