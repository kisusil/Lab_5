package ru.kisusil.icecreamrose.model;

import ru.kisusil.icecreamrose.model.humanbeing.*;

public interface HumanBeingBuilder {
    HumanBeing build();
    HumanBeingBuilder generateId();
    HumanBeingBuilder setName(String name);
    HumanBeingBuilder setMood(Mood mood);
    HumanBeingBuilder setCar(Car car);
    HumanBeingBuilder setCoordinates(Coordinates coordinates);
    HumanBeingBuilder setRealHero(Boolean realHero);
    HumanBeingBuilder setHasToothPick(boolean hasToothPick);
    HumanBeingBuilder setImpactSpeed(float impactSpeed);
    HumanBeingBuilder setMinutesOfWaiting(Long minutesOfWaiting);
    HumanBeingBuilder setWeaponType(WeaponType weaponType);

}