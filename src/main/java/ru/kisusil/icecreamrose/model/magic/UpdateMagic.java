package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.humanbeing.*;

public class UpdateMagic implements Magic {
    private final ApplicationContext applicationContext;

    public UpdateMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        HumanBeing humanBeing = applicationContext.getRepository().get(parameters.id);

        if (humanBeing == null) {
            return "Человека с таким id нет";
        }

        humanBeing.getCar().setName(parameters.carName);
        humanBeing.getCoordinates().setX(parameters.coordinateX);
        humanBeing.getCoordinates().setY(parameters.coordinateY);
        humanBeing.setHasToothpick(parameters.hasToothpick);
        humanBeing.setImpactSpeed(parameters.impactSpeed);
        humanBeing.setMinutesOfWaiting(parameters.minutesOfWaiting);
        humanBeing.setMood(parameters.mood);
        humanBeing.setWeaponType(parameters.weaponType);
        humanBeing.setName(parameters.name);
        humanBeing.setRealHero(parameters.realHero);

        return "Объект успешно изменен";
    }


}
