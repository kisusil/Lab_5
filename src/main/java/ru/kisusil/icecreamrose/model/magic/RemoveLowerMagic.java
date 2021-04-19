package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.Collection;

public class RemoveLowerMagic implements Magic {
    private final ApplicationContext applicationContext;

    public RemoveLowerMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void execute() {
        Collection<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        if (humanBeings.isEmpty()) {
            applicationContext.getIo().println("Коллекция пустая");
            return;
        }
    }
}
