package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.Collection;
import java.util.List;

public class ShowMagic implements Magic {
    private final ApplicationContext applicationContext;

    public ShowMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {

        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        String result = "Количество: " + humanBeings.size() + "\n";

        for (HumanBeing humanBeing : humanBeings) {
            result += "id " + humanBeing.getId() + "\n";
            result += "name " + humanBeing.getName() + "\n";
            result += "coordinateX " + humanBeing.getCoordinates().getX() + "\n";
            result += "coordinateY " + humanBeing.getCoordinates().getY() + "\n";
            result += "creationDate " + humanBeing.getCreationDate().toString() + "\n";
            result += "realHero " + humanBeing.getRealHero() + "\n";
            result += "hasToothPick " + humanBeing.getHasToothPick() + "\n";
            result += "impactSpeed " + humanBeing.getImpactSpeed() + "\n";
            result += "minutesOfWaiting " + humanBeing.getMinutesOfWaiting() + "\n";
            result += "weaponType " + humanBeing.getWeaponType() + "\n";
            result += "mood " + humanBeing.getMood() + "\n";
            result += "carName " +  humanBeing.getCar().getName() + "\n";
            result += "\n";
        }
        return result;
    }
}
