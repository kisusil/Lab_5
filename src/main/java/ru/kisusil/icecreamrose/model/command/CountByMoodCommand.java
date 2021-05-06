package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;
import java.util.List;

public class CountByMoodCommand implements Command {
    private final ApplicationContext applicationContext;

    public CountByMoodCommand(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        if (!(parameters instanceof MoodParameters)) {
            throw new RuntimeException("Что-то пошло не так");
        }

        MoodParameters moodParameters = (MoodParameters) parameters;
        int countByMood = 0;
        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();

        for (HumanBeing humanBeing : humanBeings) {
            if (moodParameters.mood == humanBeing.getMood()) {
                countByMood ++;
            }
        }
        return "Коллечиство элементов коллекции с заданным Mood:" + countByMood;
    }

}
