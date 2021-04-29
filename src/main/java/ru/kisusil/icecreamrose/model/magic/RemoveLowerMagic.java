package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.RepositoryException;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.Collection;
import java.util.List;

public class RemoveLowerMagic implements Magic {
    private final ApplicationContext applicationContext;

    public RemoveLowerMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute(Parameters parameters) {
        HumanBeing newHumanBeing = applicationContext.getHumanBeingCreator().create(parameters.name, parameters.coordinates, parameters.realHero, parameters.hasToothpick, parameters.impactSpeed, parameters.minutesOfWaiting, parameters.weaponType, parameters.mood, parameters.car);
        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        int sizeOne = humanBeings.size();
        if (humanBeings.isEmpty()) {
            return "Коллекция пустая";
        }

        for (HumanBeing humanBeing: humanBeings) {
            if (newHumanBeing.compareTo(humanBeing)>0) {
                try {
                    applicationContext.getRepository().delete(humanBeing.getId());
                } catch (RepositoryException e) {
                    throw new RuntimeException("Что-то пошло не так");
                }
            }

        }

        humanBeings = applicationContext.getRepository().getAll();

        if (sizeOne > humanBeings.size()){
            return "Элементы успешно удалены из коллекции";
        }

        return "Удалять нечего";
    }
}
