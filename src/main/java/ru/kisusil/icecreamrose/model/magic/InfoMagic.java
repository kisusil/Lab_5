package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.CollectionInfo;

public class InfoMagic implements Magic {
    private final ApplicationContext applicationContext;

    public InfoMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void execute () {
        CollectionInfo collectionInfo = applicationContext.getRepository().getInfo();
        applicationContext.getIo().println(collectionInfo.toString());
    }
}