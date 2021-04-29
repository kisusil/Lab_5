package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.util.Collection;
import java.util.List;

public class CountByMoodMagic implements Magic {
    private final ApplicationContext applicationContext;

    public CountByMoodMagic (ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public String execute (Parameters parameters) {
        int countByMood = 0;
        List<HumanBeing> humanBeings = applicationContext.getRepository().getAll();

        for (HumanBeing humanBeing : humanBeings) {
            if (parameters.mood == humanBeing.getMood()) {
                countByMood ++;
            }
        }
        return "Коллечиство элементов коллекции с заданным Mood:" + countByMood;
    }

}
