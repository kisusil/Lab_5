package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.CollectionInfo;
import ru.kisusil.icecreamrose.model.Parameters;

public class InfoMagic implements Magic {
    private final ApplicationContext applicationContext;

    public InfoMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        CollectionInfo collectionInfo = applicationContext.getRepository().getInfo();
        return collectionInfo.toString();
    }
}