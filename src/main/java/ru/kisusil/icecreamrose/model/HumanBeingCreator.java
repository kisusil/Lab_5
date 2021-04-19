package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.model.humanbeing.*;

import java.time.LocalDateTime;

public class HumanBeingCreator {
    private int availableId = 1;

    public HumanBeing create (String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car){
        int id = availableId;
        availableId++;

        LocalDateTime creationDate = LocalDateTime.now();

        return new HumanBeing (id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);
    }
}
