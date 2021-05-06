package ru.kisusil.icecreamrose.model.command;

import ru.kisusil.icecreamrose.model.humanbeing.Mood;
import ru.kisusil.icecreamrose.model.humanbeing.WeaponType;

public class UpdateParameters implements Parameters {
    public int id;
    public String name;
    public Boolean realHero;
    public boolean hasToothpick;
    public float impactSpeed;
    public Long minutesOfWaiting;
    public WeaponType weaponType;
    public Mood mood;
    public Integer coordinateX;
    public double coordinateY;
    public String carName;

}
