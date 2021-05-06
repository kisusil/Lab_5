package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.humanbeing.Car;
import ru.kisusil.icecreamrose.model.humanbeing.Coordinates;
import ru.kisusil.icecreamrose.model.humanbeing.Mood;
import ru.kisusil.icecreamrose.model.humanbeing.WeaponType;

public class CreationParameters implements Parameters {
    public String name;
    public Coordinates coordinates;
    public Boolean realHero;
    public boolean hasToothpick;
    public float impactSpeed;
    public Long minutesOfWaiting;
    public WeaponType weaponType;
    public Mood mood;
    public Car car;
}
