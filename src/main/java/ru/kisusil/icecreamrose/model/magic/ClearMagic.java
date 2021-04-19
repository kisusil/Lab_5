package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;

public class ClearMagic implements Magic {
    private final ApplicationContext applicationContext;

    public ClearMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void execute () {
        applicationContext.getRepository().deleteAll();
    }
}