package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.List;

public interface Repository {
    void add(HumanBeing humanBeing);
    void delete(int id) throws RepositoryException;
    void deleteAll();
    HumanBeing get(int id);
    List<HumanBeing> getAll();
    CollectionInfo getInfo();
}
