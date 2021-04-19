package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;

public class SaveMagic implements Magic {
    private final ApplicationContext applicationContext;

    public SaveMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void execute() {

    }
}
