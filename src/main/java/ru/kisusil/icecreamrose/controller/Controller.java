package ru.kisusil.icecreamrose.controller;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.Car;
import ru.kisusil.icecreamrose.model.humanbeing.Coordinates;
import ru.kisusil.icecreamrose.model.humanbeing.Mood;
import ru.kisusil.icecreamrose.model.humanbeing.WeaponType;

public interface Controller {
    void add(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car);
    void clear();
    void executeScript(String fileName);
    void info();
    void removeById(int id);
    void removeLower();
    void save();
    void show();
    void update(int id, String name, Integer coordinateX, double coordinateY, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, String  carName);
    void addIfMax();
    void countByMood();
    void filterGreaterThanMood();
    void history();
    void printAscending();
    void help();
}
