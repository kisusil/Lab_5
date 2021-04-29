package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;

public class SaveMagic implements Magic {
    private final ApplicationContext applicationContext;

    public SaveMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public String execute(Parameters parameters) {
        return "Успешное сохранение в файл";
    }
}
