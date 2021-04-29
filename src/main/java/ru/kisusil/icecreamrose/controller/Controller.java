package ru.kisusil.icecreamrose.controller;

import ru.kisusil.icecreamrose.model.humanbeing.Car;
import ru.kisusil.icecreamrose.model.humanbeing.Coordinates;
import ru.kisusil.icecreamrose.model.humanbeing.Mood;
import ru.kisusil.icecreamrose.model.humanbeing.WeaponType;

public interface Controller {
    String add(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car);
    String clear();
    String executeScript(String fileName);
    String info();
    String removeById(int id);
    String removeLower(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car);
    String save();
    String show();
    String update(int id, String name, Integer coordinateX, double coordinateY, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, String  carName);
    String addIfMax(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, Long minutesOfWaiting, WeaponType weaponType, Mood mood, Car car);
    String countByMood(Mood mood);
    String filterGreaterThanMood(Mood mood);
    String printAscending();
    String help();
}
