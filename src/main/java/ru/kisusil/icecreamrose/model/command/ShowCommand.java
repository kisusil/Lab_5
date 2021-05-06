package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.List;

public class ShowCommand implements Command {
    private final ApplicationContext applicationContext;

    public ShowCommand(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        if (!(parameters instanceof EmptyParameters)) {
            throw new RuntimeException("Что-то пошло не так");
        }

        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();
        StringBuilder result = new StringBuilder("Количество: " + humanBeings.size() + "\n");

        for (HumanBeing humanBeing : humanBeings) {
            result.append("id ").append(humanBeing.getId()).append("\n");
            result.append("name ").append(humanBeing.getName()).append("\n");
            result.append("coordinateX ").append(humanBeing.getCoordinates().getX()).append("\n");
            result.append("coordinateY ").append(humanBeing.getCoordinates().getY()).append("\n");
            result.append("creationDate ").append(humanBeing.getCreationDate().toString()).append("\n");
            result.append("realHero ").append(humanBeing.getRealHero()).append("\n");
            result.append("hasToothPick ").append(humanBeing.getHasToothPick()).append("\n");
            result.append("impactSpeed ").append(humanBeing.getImpactSpeed()).append("\n");
            result.append("minutesOfWaiting ").append(humanBeing.getMinutesOfWaiting()).append("\n");
            result.append("weaponType ").append(humanBeing.getWeaponType()).append("\n");
            result.append("mood ").append(humanBeing.getMood()).append("\n");
            result.append("carName ").append(humanBeing.getCar().getName()).append("\n");
            result.append("\n");
        }
        return result.toString();
    }
}
