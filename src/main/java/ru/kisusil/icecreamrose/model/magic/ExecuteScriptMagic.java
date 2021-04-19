package ru.kisusil.icecreamrose.model.magic;

import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.Car;
import ru.kisusil.icecreamrose.model.humanbeing.Coordinates;
import ru.kisusil.icecreamrose.model.humanbeing.Mood;
import ru.kisusil.icecreamrose.model.humanbeing.WeaponType;
import ru.kisusil.icecreamrose.view.Console;
import ru.kisusil.icecreamrose.view.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ExecuteScriptMagic implements Magic {
    private final ApplicationContext applicationContext;
    private final String fileName;
    public ExecuteScriptMagic(ApplicationContext applicationContext, String fileName) {
        this.applicationContext = applicationContext;
        this.fileName = fileName;
    }


    @Override
    public void execute() {
        try(IO io = new Console(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8), System.out)) {
            while (io.hasNext()) {
                String line = io.readLine();

                if (line.equals("add")) {
                    doAdd(io);
                } else if (line.equals("clear")) {
                    ClearMagic clearCommand = new ClearMagic(applicationContext);
                    clearCommand.execute();
                } else if (line.equals("info")){
                    InfoMagic infoCommand = new InfoMagic(applicationContext);
                    infoCommand.execute();
                } else if (line.equals("show")) {
                    ShowMagic showCommand = new ShowMagic(applicationContext);
                    showCommand.execute();
                } else if (line.contains("update")) {
                    doUpdate(line, io);
                } else if (line.contains("remove_by_id")) {
                    doRemoveById(line, io);
                } else {
                    io.println("Такой команды не существует");
                    throw new ExecuteScriptException();
                }
            }
            io.println("Скрипт успешно выполнен");
        } catch (ExecuteScriptException e){
            applicationContext.getIo().println("Скрипт содержит ошибки. Выполнение скрипта прервано.");
        } catch (FileNotFoundException e) {
            applicationContext.getIo().println("Файл с таким именем не существует");
        } catch (Exception e) {
            applicationContext.getIo().println("Непредвиденная ошибка чтения из файла");
        }
    }

    private String readName(IO io) throws ExecuteScriptException {
        String line = io.readLine();
        String name;

        if (line.isEmpty()) {
            io.println("Это поле не может быть пустым. Введите name еще раз:");
            throw new ExecuteScriptException();
        }

        name = line;
        return name;
    }

    private Boolean readRealHero (IO io) throws ExecuteScriptException {
        String line = io.readLine();
        if (line.isEmpty()) {
            io.println("Это поле не может быть пустым. Пожалуйста, введите realHero еще раз:");
            throw new ExecuteScriptException();
        }
        if (line.equalsIgnoreCase("true")){
            return true;
        }
        if (line.equalsIgnoreCase("false")) {
            return false;
        }
        io.println("Это поле может принимать значения true или false. Пожалуйста, введите realHero еще раз:");
        throw new ExecuteScriptException();
    }


    private boolean readHasToothpick (IO io) throws ExecuteScriptException {
        String line = io.readLine();
        if (line.isEmpty()) {
            io.println("Это поле не может быть пустым. Пожалуйста, введите hasToothpick еще раз:");
            throw new ExecuteScriptException();
        }
        if (line.equalsIgnoreCase("true")){
            return true;
        }
        if (line.equalsIgnoreCase("false")) {
            return false;
        }
        io.println("Это поле может принимать значения true или false. Пожалуйста, введите hasToothpick еще раз:");
        throw new ExecuteScriptException();
    }

    private Integer readX (IO io) throws ExecuteScriptException{
        String line = io.readLine();
        Integer x;

        if (line.isEmpty()) {
            io.println("Это поле не может быть пустым. Пожалуйста, введите X еще раз:");
            throw new ExecuteScriptException();
        }

        try {
            x = Integer.parseInt(line);
        } catch(NumberFormatException e) {
            io.println("Это поле должно быть целым числом. Пожалуйста, введите x еще раз:");
            throw new ExecuteScriptException();
        }

        if (x < -475 ){
            io.println("Это поле не может быть < -475. Пожалуйста, введите x еще раз:");
            throw new ExecuteScriptException();
        }
        return x;
    }

    private double readY (IO io) throws ExecuteScriptException{
        String line = io.readLine();
        double y;

        if (line.isEmpty()) {
            io.println("Это поле не может быть пустым. Пожалуйста, введите Y еще раз:");
            throw new ExecuteScriptException();
        }

        try {
            y = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            io.println("Это поле должно быть дробным числом. Пожалуйста, введите Y еще раз:");
            throw new ExecuteScriptException();
        }

        if (y < -533) {
            io.println("Это поле не может быть < -533. Пожалуйста, введите Y еще раз:");
            throw new ExecuteScriptException();
        }
        return y;
    }

    private Float readImpactSpeed (IO io) throws ExecuteScriptException{
        String line = io.readLine();
        float impactSpeed;
        try {
            impactSpeed = Float.parseFloat(line);
        } catch (NumberFormatException e) {
            io.println("Это поле может принимать дробные или целые числа. Введите impactSpeed еще раз.");
            throw new ExecuteScriptException();
        }

        return impactSpeed;
    }

    private Long readMinutesOfWaiting (IO io) throws ExecuteScriptException{
        String line = io.readLine();
        Long minutesOfWaiting;
        if (line.isEmpty()) {
            return null;
        }
        try {
            minutesOfWaiting = Long.parseLong(line);
        }
        catch (NumberFormatException e) {
            io.println("Это поле может принимать только целые числа. Введите minutesOfWaiting еще раз.");
            throw new ExecuteScriptException();
        }

        return minutesOfWaiting;
    }

    private WeaponType readWeaponType (IO io) throws ExecuteScriptException{
        String line = io.readLine().toUpperCase();
        WeaponType weaponType;

        if (line.isEmpty()) {
            return null;
        }

        try {
            weaponType = WeaponType.valueOf(line);
        } catch(IllegalArgumentException e) {
            io.println("Это поле должно принимать одно из значений: AXE, SHOTGUN, KNIFE, MACHINE_GUN. Пожалуйста, введите weaponType еще раз:");
            throw new ExecuteScriptException();
        }

        return weaponType;
    }

    private Mood readMood (IO io) throws ExecuteScriptException{
        String line = io.readLine().toUpperCase();
        Mood mood;
        if (line.isEmpty()) {
            return null;
        }

        try {
            mood = Mood.valueOf(line);
        } catch(IllegalArgumentException e) {
            io.println("Это поле должно принимать одно из значений: SADNESS, LONGING, CALM, FRENZY. Пожалуйста, введите weaponType еще раз:");
            throw new ExecuteScriptException();
        }

        return mood;

    }

    private String readNameCar (IO io){
        String line = io.readLine();
        String nameCar;

        if (line.isEmpty()) {
            return null;
        }

        nameCar = line;
        return nameCar;
    }

    private void doAdd(IO io) throws ExecuteScriptException {
        String name = readName(io);

        Boolean realHero = readRealHero(io);

        boolean hasToothpick = readHasToothpick(io);

        float impactSpeed = readImpactSpeed(io);

        Long minutesOfWaiting = readMinutesOfWaiting(io);

        Integer x = readX(io);

        double y = readY(io);

        WeaponType weaponType = readWeaponType(io);

        Mood mood = readMood(io);

        String nameCar = readNameCar(io);

        Coordinates coordinates = new Coordinates(x,y);
        Car car = new Car(nameCar);

        AddMagic addMagic = new AddMagic(applicationContext, name, coordinates, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);
        addMagic.execute();
    }

    private void doUpdate(String line, IO io) throws ExecuteScriptException {
        int id;
        if (line.length()<8){
            io.println("Вы забыли ввести id");
            throw new ExecuteScriptException();
        }
        String StringId = line.substring(7);

        try {
            id = Integer.parseInt(StringId);
        } catch(NumberFormatException e){
            io.println("Вы ввели id, которое не является числом");
            throw new ExecuteScriptException();
        }

        String name = readName(io);

        Boolean realHero = readRealHero(io);

        boolean hasToothpick = readHasToothpick(io);

        float impactSpeed = readImpactSpeed(io);

        Long minutesOfWaiting = readMinutesOfWaiting(io);

        Integer x = readX(io);

        double y = readY(io);

        WeaponType weaponType = readWeaponType(io);

        Mood mood = readMood(io);

        String nameCar = readNameCar(io);

        UpdateMagic updateCommand = new UpdateMagic(applicationContext, id, name, x, y, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, nameCar);
        updateCommand.execute();
    }

    private void doRemoveById(String line, IO io) throws ExecuteScriptException {
        int id;
        if (line.length()<14){
            io.println("Вы забыли ввести Id.");
            throw new ExecuteScriptException();
        }

        String StringId = line.substring(13);

        try {
            id = Integer.parseInt(StringId);

        } catch(NumberFormatException e){
            io.println("Id должно быть целым числом.");
            throw new ExecuteScriptException();
        }

        RemoveByIdMagic removeByIdCommand = new RemoveByIdMagic(applicationContext,id);
        removeByIdCommand.execute();
    }
}
