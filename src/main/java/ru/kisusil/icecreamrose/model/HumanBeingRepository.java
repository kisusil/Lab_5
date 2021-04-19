package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;

public class HumanBeingRepository implements Repository {
    private CollectionInfo collectionInfo;
    private final LinkedHashSet<HumanBeing> linkedHashSet = new LinkedHashSet<>();

    public HumanBeingRepository() {
        collectionInfo = new CollectionInfo("LinkedHashSet", LocalDateTime.now(), 0);
    }

    public void add(HumanBeing humanBeing) {
        linkedHashSet.add(humanBeing);
        collectionInfo.setSize(collectionInfo.getSize() + 1);
    }

    public void delete(int id) throws RepositoryException {
        HumanBeing humanBeing = get(id);

        if (humanBeing != null) {
            linkedHashSet.remove(humanBeing);
            collectionInfo.setSize(collectionInfo.getSize() - 1);
        } else {
            throw new RepositoryException("Человека с таким id не существует");
        }
    }

    public void deleteAll() {
        linkedHashSet.clear();
        collectionInfo.setSize(0);
    }

    public HumanBeing get(int id) {
        for (HumanBeing humanBeing : linkedHashSet) {
            if (humanBeing.getId() == id) {
                return humanBeing;
            }
        }

        return null;
    }

    public Collection<HumanBeing> getAll() {
        return linkedHashSet;
    }

    public CollectionInfo getInfo() {
        return collectionInfo;
    }
}