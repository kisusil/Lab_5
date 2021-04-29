package ru.kisusil.icecreamrose.controller;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.Parameters;
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
    public String add (String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car) {
        Parameters parameters = new Parameters();

        parameters.name = name;
        parameters.car = car;
        parameters.coordinates = coordinates;
        parameters.realHero = realHero;
        parameters.hasToothpick = hasToothpick;
        parameters.impactSpeed = impactSpeed;
        parameters.minutesOfWaiting = minutesOfWaiting;
        parameters.weaponType = weaponType;
        parameters.mood = mood;

        return applicationContext.getMagics().get("add").execute(parameters);
    }

    @Override
    public String clear() {
        Parameters parameters = new Parameters();

        return applicationContext.getMagics().get("clear").execute(parameters);
    }

    @Override
    public String executeScript(String fileName) {
        Parameters parameters = new Parameters();

        parameters.fileName = fileName;

        return applicationContext.getMagics().get("executeScript").execute(parameters);
    }

    @Override
    public String info() {
        Parameters parameters = new Parameters();

        return applicationContext.getMagics().get("info").execute(parameters);
    }

    @Override
    public String  removeById(int id) {
        Parameters parameters = new Parameters();

        parameters.id = id;

        return applicationContext.getMagics().get("removeById").execute(parameters);
    }

    @Override
    public String removeLower(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car) {
        Parameters parameters = new Parameters();

        parameters.name = name;
        parameters.car = car;
        parameters.coordinates = coordinates;
        parameters.realHero = realHero;
        parameters.hasToothpick = hasToothpick;
        parameters.impactSpeed = impactSpeed;
        parameters.minutesOfWaiting = minutesOfWaiting;
        parameters.weaponType = weaponType;
        parameters.mood = mood;

        return applicationContext.getMagics().get("removeLower").execute(parameters);
    }

    @Override
    public String save() {
        Parameters parameters = new Parameters();

        return applicationContext.getMagics().get("save").execute(parameters);
    }

    @Override
    public String show() {
        Parameters parameters = new Parameters();

        return applicationContext.getMagics().get("show").execute(parameters);
    }

    @Override
    public String update(int id, String name, Integer coordinateX, double coordinateY, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, String carName) {
        Parameters parameters = new Parameters();

        parameters.id = id;
        parameters.name = name;
        parameters.carName = carName;
        parameters.coordinateX = coordinateX;
        parameters.coordinateY = coordinateY;
        parameters.realHero = realHero;
        parameters.hasToothpick = hasToothpick;
        parameters.impactSpeed = impactSpeed;
        parameters.minutesOfWaiting = minutesOfWaiting;
        parameters.weaponType = weaponType;
        parameters.mood = mood;

        return applicationContext.getMagics().get("update").execute(parameters);
    }

    @Override
    public String addIfMax(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car) {
        Parameters parameters = new Parameters();

        parameters.name = name;
        parameters.car = car;
        parameters.coordinates = coordinates;
        parameters.realHero = realHero;
        parameters.hasToothpick = hasToothpick;
        parameters.impactSpeed = impactSpeed;
        parameters.minutesOfWaiting = minutesOfWaiting;
        parameters.weaponType = weaponType;
        parameters.mood = mood;

        return applicationContext.getMagics().get("addIfMax").execute(parameters);
    }

    @Override
    public String countByMood(Mood mood) {
        Parameters parameters = new Parameters();
        parameters.mood = mood;

        return applicationContext.getMagics().get("countByMood").execute(parameters);
    }

    @Override
    public String filterGreaterThanMood(Mood mood) {
        Parameters parameters = new Parameters();
        parameters.mood = mood;

        return applicationContext.getMagics().get("filterGreaterThanMood").execute(parameters);
    }

    @Override
    public String printAscending() {
        Parameters parameters = new Parameters();

        return applicationContext.getMagics().get("printAscending").execute(parameters);
    }

    @Override
    public String help() {
        Parameters parameters = new Parameters();

        return applicationContext.getMagics().get("help").execute(parameters);
    }
}
