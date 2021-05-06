package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.ApplicationContext;

public class ClearCommand implements Command {
    private final ApplicationContext applicationContext;

    public ClearCommand(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        if (!(parameters instanceof EmptyParameters)) {
            throw new RuntimeException("Что-то пошло не так");
        }

        applicationContext.getRepository().deleteAll();
        return "Коллекция успешно очищена";
    }
}