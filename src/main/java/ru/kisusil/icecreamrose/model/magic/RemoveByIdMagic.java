package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.RepositoryException;

public class RemoveByIdMagic implements Magic {
    private final ApplicationContext applicationContext;
    private int id;

    public RemoveByIdMagic(ApplicationContext applicationContext, int id) {
        this.applicationContext = applicationContext;
        this.id = id;
    }


    @Override
    public void execute() {
        try {
            applicationContext.getRepository().delete(id);
        }
        catch (RepositoryException e){
            applicationContext.getIo().println("Человека с таким id не существует");
        }
    }
}
