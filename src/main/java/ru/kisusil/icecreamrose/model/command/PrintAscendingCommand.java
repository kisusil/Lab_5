package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.ApplicationContext;

public class PrintAscendingCommand implements Command {
    private final ApplicationContext applicationContext;

    public PrintAscendingCommand(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute(Parameters parameters) {
        if (!(parameters instanceof EmptyParameters)) {
            throw new RuntimeException("Что-то пошло не так");
        }

        return applicationContext.getCommands().get("show").execute(parameters);
    }
}
