package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.RepositoryException;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.List;

public class RemoveLowerCommand implements Command {
    private final ApplicationContext applicationContext;

    public RemoveLowerCommand(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute(Parameters parameters) {
        if (!(parameters instanceof CreationParameters)) {
            throw new RuntimeException("Что-то пошло не так");
        }

        CreationParameters creationParameters = (CreationParameters) parameters;
        HumanBeing newHumanBeing = applicationContext
                .getHumanBeingBuilder()
                .generateId()
                .setName(creationParameters.name)
                .setCar(creationParameters.car)
                .setCoordinates(creationParameters.coordinates)
                .setHasToothPick(creationParameters.hasToothpick)
                .setImpactSpeed(creationParameters.impactSpeed)
                .setMinutesOfWaiting(creationParameters.minutesOfWaiting)
                .setMood(creationParameters.mood)
                .setRealHero(creationParameters.realHero)
                .setWeaponType(creationParameters.weaponType)
                .build();
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
