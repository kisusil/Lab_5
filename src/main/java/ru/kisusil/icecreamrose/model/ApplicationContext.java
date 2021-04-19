package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.view.IO;

public class ApplicationContext {
private HumanBeingCreator humanBeingCreator;
private Repository repository;
private IO io;

    public ApplicationContext(HumanBeingCreator humanBeingCreator, Repository repository, IO io) {
        this.humanBeingCreator = humanBeingCreator;
        this.repository = repository;
        this.io = io;
    }

    public HumanBeingCreator getHumanBeingFactory() {
        return humanBeingCreator;
    }

    public Repository getRepository() {
        return repository;
    }

    public IO getIo() { return io; }
}
