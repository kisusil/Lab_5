package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;

public class ClearMagic implements Magic {
    private final ApplicationContext applicationContext;

    public ClearMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        applicationContext.getRepository().deleteAll();
        return "Коллекция успешно очищена";
    }
}