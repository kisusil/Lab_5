package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.model.magic.Magic;

import java.util.Map;

public class ApplicationContext {
    private final HumanBeingCreator humanBeingCreator;
    private final Repository repository;
    private Map <String, Magic> magics;

    public ApplicationContext(HumanBeingCreator humanBeingCreator, Repository repository) {
        this.humanBeingCreator = humanBeingCreator;
        this.repository = repository;
    }


    public void setMagics(Map<String, Magic> magics) {
        this.magics = magics;
    }

    public Map<String, Magic> getMagics() {
        return magics;
    }

    public HumanBeingCreator getHumanBeingCreator() {
        return humanBeingCreator;
    }

    public Repository getRepository() {
        return repository;
    }
}
