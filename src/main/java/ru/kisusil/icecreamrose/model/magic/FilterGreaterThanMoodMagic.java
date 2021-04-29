package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.ArrayList;
import java.util.List;

public class FilterGreaterThanMoodMagic implements Magic {
    private final ApplicationContext applicationContext;

    public FilterGreaterThanMoodMagic(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private String listString(List<HumanBeing> list){
        String result = "quantity: " + list.size();

        for (HumanBeing humanBeing : list) {
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

    @Override
    public String execute(Parameters parameters) {
        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        List<HumanBeing> list = new ArrayList<>();

        if (humanBeings.isEmpty()) {
            return "Коллекция пустая";
        }

        for (HumanBeing humanBeing : humanBeings) {
            if (parameters.mood.number - humanBeing.getMood().number < 0) {
                list.add(humanBeing);
            }
        }
        if (list.size()!=0) {
            return listString(list);
        }
        return "Таких элементов нет";
    }
}
