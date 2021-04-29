package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;

public class PrintAscendingMagic implements Magic {
    private final ApplicationContext applicationContext;

    public PrintAscendingMagic (ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute(Parameters parameters) {
        return applicationContext.getMagics().get("show").execute(parameters);
    }
}
