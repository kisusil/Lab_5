package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.CollectionInfo;

public class InfoCommand implements Command {
    private final ApplicationContext applicationContext;

    public InfoCommand(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        if (!(parameters instanceof EmptyParameters)) {
            throw new RuntimeException("Что-то пошло не так");
        }

        CollectionInfo collectionInfo = applicationContext.getRepository().getInfo();
        return collectionInfo.toString();
    }
}