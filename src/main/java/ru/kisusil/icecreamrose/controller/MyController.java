package ru.kisusil.icecreamrose.controller;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.magic.*;
import ru.kisusil.icecreamrose.model.humanbeing.Car;
import ru.kisusil.icecreamrose.model.humanbeing.Coordinates;
import ru.kisusil.icecreamrose.model.humanbeing.Mood;
import ru.kisusil.icecreamrose.model.humanbeing.WeaponType;

public class MyController implements Controller {
    private final ApplicationContext applicationContext;

    public MyController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void add(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car) {
        AddMagic addMagic = new AddMagic(applicationContext, name, coordinates, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);
        addMagic.execute();

    }

    @Override
    public void clear() {
        ClearMagic clearMagic = new ClearMagic(applicationContext);
        clearMagic.execute();

    }

    @Override
    public void executeScript(String fileName) {
        ExecuteScriptMagic executeScriptMagic= new ExecuteScriptMagic(applicationContext, fileName);
        executeScriptMagic.execute();


    }

    @Override
    public void info() {
        InfoMagic infoMagic = new InfoMagic(applicationContext);
        infoMagic.execute();

    }

    @Override
    public void removeById(int id) {
        RemoveByIdMagic removeByIdMagic = new RemoveByIdMagic(applicationContext, id);
        removeByIdMagic.execute();

    }

    @Override
    public void removeLower() {
        RemoveLowerMagic removeLowerMagic = new RemoveLowerMagic(applicationContext);
        removeLowerMagic.execute();

    }

    @Override
    public void save() {
        SaveMagic saveMagic = new SaveMagic(applicationContext);
        saveMagic.execute();

    }

    @Override
    public void show() {
        ShowMagic showMagic = new ShowMagic(applicationContext);
        showMagic.execute();

    }

    @Override
    public void update(int id, String name, Integer coordinateX, double coordinateY, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, String carName) {
        UpdateMagic updateMagic = new UpdateMagic(applicationContext, id, name, coordinateX, coordinateY, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, carName);
        updateMagic.execute();
    }

    @Override
    public void addIfMax() {

    }

    @Override
    public void countByMood() {

    }

    @Override
    public void filterGreaterThanMood() {

    }

    @Override
    public void history() {

    }

    @Override
    public void printAscending() {

    }

    @Override
    public void help() {
        HelpMagic helpMagic = new HelpMagic(applicationContext);
        helpMagic.execute();
    }
}
