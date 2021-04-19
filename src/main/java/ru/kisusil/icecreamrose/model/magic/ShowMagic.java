package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.Collection;

public class ShowMagic implements Magic {
    private final ApplicationContext applicationContext;

    public ShowMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void execute () {

        Collection<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        applicationContext.getIo().println("quantity: " + humanBeings.size());

        for (HumanBeing humanBeing : humanBeings) {
            applicationContext.getIo().println("id " + humanBeing.getId());
            applicationContext.getIo().println("name " + humanBeing.getName());
            applicationContext.getIo().println("coordinateX " + humanBeing.getCoordinates().getX());
            applicationContext.getIo().println("coordinateY " + humanBeing.getCoordinates().getY());
            applicationContext.getIo().println("creationDate " + humanBeing.getCreationDate().toString());
            applicationContext.getIo().println("realHero " + humanBeing.getRealHero());
            applicationContext.getIo().println("hasToothPick " + humanBeing.getHasToothPick());
            applicationContext.getIo().println("impactSpeed " + humanBeing.getImpactSpeed());
            applicationContext.getIo().println("minutesOfWaiting " + humanBeing.getMinutesOfWaiting());
            applicationContext.getIo().println("weaponType " + humanBeing.getWeaponType());
            applicationContext.getIo().println("mood " + humanBeing.getMood());
            applicationContext.getIo().println("carName " +  humanBeing.getCar().getName());
            applicationContext.getIo().println("");
        }
    }
}
