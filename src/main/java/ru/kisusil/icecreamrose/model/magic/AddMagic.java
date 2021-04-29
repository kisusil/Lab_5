package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.humanbeing.*;

public class AddMagic implements Magic {
    private final ApplicationContext applicationContext;

    public AddMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        HumanBeing humanBeing = applicationContext.getHumanBeingCreator().create (parameters.name, parameters.coordinates, parameters.realHero, parameters.hasToothpick, parameters.impactSpeed, parameters.minutesOfWaiting, parameters.weaponType, parameters.mood, parameters.car);
        applicationContext.getRepository().add(humanBeing);
        return "Объект успешно добавлен в коллекцию";
    }

}
