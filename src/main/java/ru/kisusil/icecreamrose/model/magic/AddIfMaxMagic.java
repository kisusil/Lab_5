package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.List;

public class AddIfMaxMagic implements Magic {
    private final ApplicationContext applicationContext;

    public AddIfMaxMagic (ApplicationContext applicationContext) {this.applicationContext = applicationContext; }

    @Override
    public String execute(Parameters parameters) {

        HumanBeing humanBeing = applicationContext.getHumanBeingCreator().create(parameters.name, parameters.coordinates, parameters.realHero, parameters.hasToothpick, parameters.impactSpeed, parameters.minutesOfWaiting, parameters.weaponType, parameters.mood, parameters.car);
        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        int indexMax = humanBeings.size() - 1;
        HumanBeing maxHumanBeing = humanBeings.get(indexMax);
        if (humanBeing.compareTo(maxHumanBeing)>0) {
            applicationContext.getRepository().add(humanBeing);
            return "Объект успешно добавлен в коллекцию";
        } else { return "Введенный элемент не максимальный"; }
    }
}
