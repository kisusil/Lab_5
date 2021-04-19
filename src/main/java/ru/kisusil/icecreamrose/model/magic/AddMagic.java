package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.*;

public class AddMagic implements Magic {
    private final ApplicationContext applicationContext;
    private String name;
    private Coordinates coordinates;
    private Boolean realHero;
    private boolean hasToothpick;
    private float impactSpeed;
    private Long minutesOfWaiting;
    private WeaponType weaponType;
    private Mood mood;
    private Car car;

    public AddMagic(ApplicationContext applicationContext, String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car) {
        this.applicationContext = applicationContext;
        this.name = name;
        this.coordinates = coordinates;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    @Override
    public void execute () {
        HumanBeing humanBeing = applicationContext.getHumanBeingFactory().create (name, coordinates, realHero, hasToothpick,impactSpeed, minutesOfWaiting, weaponType, mood, car);
        applicationContext.getRepository().add(humanBeing);
    }

}
