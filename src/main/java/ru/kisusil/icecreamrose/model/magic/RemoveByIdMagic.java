package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.RepositoryException;

public class RemoveByIdMagic implements Magic {
    private final ApplicationContext applicationContext;

    public RemoveByIdMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public String execute(Parameters parameters) {
        try {
            applicationContext.getRepository().delete(parameters.id);
            return "Объект успешно удален";
        }
        catch (RepositoryException e){
            return "Человека с таким id не существует";
        }
    }
}
