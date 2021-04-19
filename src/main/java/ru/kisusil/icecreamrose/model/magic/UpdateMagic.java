package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.*;

public class UpdateMagic implements Magic {
    private final ApplicationContext applicationContext;
    private int id;
    private String name;
    private Integer coordinateX;
    private double coordinateY;
    private Boolean realHero;
    private boolean hasToothpick;
    private float impactSpeed;
    private Long minutesOfWaiting;
    private WeaponType weaponType;
    private Mood mood;
    private String carName;

    public UpdateMagic(ApplicationContext applicationContext, int id, String name, Integer coordinateX, double coordinateY, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, String  carName) {
        this.id = id;
        this.applicationContext = applicationContext;
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.mood = mood;
        this.carName = carName;
    }

    @Override
    public void execute () {
        HumanBeing humanBeing = applicationContext.getRepository().get(id);

        if (humanBeing == null) {
            applicationContext.getIo().println("Человека с таким id нет.");
            return;
        }

        humanBeing.getCar().setName(carName);
        humanBeing.getCoordinates().setX(coordinateX);
        humanBeing.getCoordinates().setY(coordinateY);
        humanBeing.setHasToothpick(hasToothpick);
        humanBeing.setImpactSpeed(impactSpeed);
        humanBeing.setMinutesOfWaiting(minutesOfWaiting);
        humanBeing.setMood(mood);
        humanBeing.setWeaponType(weaponType);
        humanBeing.setName(name);
        humanBeing.setRealHero(realHero);
    }


}
