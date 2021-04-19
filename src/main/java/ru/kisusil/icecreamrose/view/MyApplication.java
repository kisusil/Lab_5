package ru.kisusil.icecreamrose.view;

import ru.kisusil.icecreamrose.controller.Controller;
import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.humanbeing.*;

public class MyApplication implements Application{
    private final IO io;
    private final ApplicationContext applicationContext;
    private final Controller controller;

    public MyApplication(IO io, ApplicationContext applicationContext, Controller controller) {
        this.io = io;
        this.applicationContext = applicationContext;
        this.controller = controller;
    }

    private String readName() {
        while (true) {
            String line = io.readLine();
            String name;

            if (line.isEmpty()) {
                io.println("Это поле не может быть пустым. Введите name еще раз:");
                continue;
            }

            name = line;
            return name;
        }
    }

    private Boolean readRealHero (){
        while (true) {
            String line = io.readLine();
            if (line.isEmpty()) {
                io.println("Это поле не может быть пустым. Пожалуйста, введите realHero еще раз:");
                continue;
            }
            if (line.equalsIgnoreCase("true")){
                return true;
            }
            if (line.equalsIgnoreCase("false")) {
                return false;
            }
            io.println("Это поле может принимать значения true или false. Пожалуйста, введите realHero еще раз:");
        }
    }


    private boolean readHasToothpick () {
        while (true) {
            String line = io.readLine();
            if (line.isEmpty()) {
                io.println("Это поле не может быть пустым. Пожалуйста, введите hasToothpick еще раз:");
                continue;
            }
            if (line.equalsIgnoreCase("true")){
                return true;
            }
            if (line.equalsIgnoreCase("false")) {
                return false;
            }
            io.println("Это поле может принимать значения true или false. Пожалуйста, введите hasToothpick еще раз:");
        }
    }

    private Integer readX (){
        while (true) {
            String line = io.readLine();
            Integer x;

            if (line.isEmpty()) {
                io.println("Это поле не может быть пустым. Пожалуйста, введите X еще раз:");
                continue;
            }

            try {
                x = Integer.parseInt(line);
            } catch(NumberFormatException e) {
                io.println("Это поле должно быть целым числом. Пожалуйста, введите x еще раз:");
                continue;
            }

            if (x < -475 ){
                io.println("Это поле не может быть < -475. Пожалуйста, введите x еще раз:");
                continue;
            }
            return x;
        }
    }

    private double readY (){
        while (true) {
            String line = io.readLine();
            double y;

            if (line.isEmpty()) {
                io.println("Это поле не может быть пустым. Пожалуйста, введите Y еще раз:");
                continue;
            }

            try {
                y = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                io.println("Это поле должно быть дробным числом. Пожалуйста, введите Y еще раз:");
                continue;
            }

            if (y < -533) {
                io.println("Это поле не может быть < -533. Пожалуйста, введите Y еще раз:");
                continue;
            }
            return y;
        }
    }

    private Float readImpactSpeed (){
        while (true) {
            String line = io.readLine();
            float impactSpeed;
            try {
                impactSpeed = Float.parseFloat(line);
            } catch (NumberFormatException e) {
                io.println("Это поле может принимать дробные или целые числа. Введите impactSpeed еще раз.");
                continue;
            }

            return impactSpeed;
        }
    }

    private Long readMinutesOfWaiting (){
        while (true) {
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
                continue;
            }

            return minutesOfWaiting;
        }
    }

    private WeaponType readWeaponType (){
        while (true) {
            String line = io.readLine().toUpperCase();
            WeaponType weaponType;

            if (line.isEmpty()) {
                return null;
            }

            try {
                weaponType = WeaponType.valueOf(line);
            } catch(IllegalArgumentException e) {
                io.println("Это поле должно принимать одно из значений: AXE, SHOTGUN, KNIFE, MACHINE_GUN. Пожалуйста, введите weaponType еще раз:");
                continue;
            }

            return weaponType;
        }
    }

    private Mood readMood (){
        while (true) {
            String line = io.readLine().toUpperCase();
            Mood mood;
            if (line.isEmpty()) {
                return null;
            }

            try {
                mood = Mood.valueOf(line);
            } catch(IllegalArgumentException e) {
                io.println("Это поле должно принимать одно из значений: SADNESS, LONGING, CALM, FRENZY. Пожалуйста, введите weaponType еще раз:");
                continue;
            }

            return mood;
        }

    }

    private String readNameCar (){
        String line = io.readLine();
        String nameCar;

        if (line.isEmpty()) {
            return null;
        }

        nameCar = line;
        return nameCar;
    }

    @Override
    public void start(){
        while (true) {
            io.println("");
            io.println("Введите команду:");
            String line = io.readLine();

            if (line.equals("add")) {
                doAdd();
            } else if (line.equals("clear")) {
                controller.clear();
            } else if (line.equals("info")){
                controller.info();
            } else if (line.equals("show")) {
                controller.show();
            } else if (line.equals("help")) {
                controller.help();
            } else if (line.contains("update")) {
                doUpdate(line);
            } else if (line.contains("remove_by_id")) {
                doRemoveById(line);
            } else if (line.equals("exit")) {
                io.println("Программа завершена.");
                break;
            } else if (line.contains("execute_script")){
                if (line.length()<16){
                    io.println("Вы забыли ввести fileName. Введите execute_script еще раз:");
                    continue;
                }
                String fileName = line.substring(15);
                controller.executeScript(fileName);

            } else {
                io.println("Такой команды не существует");
            }
        }
    }

    private void doAdd() {
        io.println("Введите name:");
        String name = readName();

        io.println("Введите realHero:");
        Boolean realHero = readRealHero();

        io.println("Введите hasToothPick:");
        boolean hasToothpick = readHasToothpick();

        io.println("Введите impactSpeed:");
        float impactSpeed = readImpactSpeed();

        io.println("Введите minutesOfWaiting:");
        Long minutesOfWaiting = readMinutesOfWaiting();

        io.println("Введите coordinate X:");
        Integer x = readX();

        io.println("Введите coordinate Y:");
        double y = readY();

        io.println("Введите weaponType:");
        WeaponType weaponType = readWeaponType();

        io.println("Введите mood:");
        Mood mood = readMood();

        io.println("Введите nameCar:");
        String nameCar = readNameCar();

        Coordinates coordinates = new Coordinates(x,y);
        Car car = new Car(nameCar);

        controller.add(name, coordinates, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);

    }

    private void doUpdate(String line) {
        int id;
        if (line.length()<8){
            io.println("Вы забыли ввести Id. Введите update еще раз:");
            return;
        }
        String StringId = line.substring(7);

        try {
            id = Integer.parseInt(StringId);

        } catch(NumberFormatException e){
            io.println("Id должно быть целым числом. Введите update еще раз:");
            return;
        }

        io.println("Введите name:");
        String name = readName();

        io.println("Введите realHero:");
        Boolean realHero = readRealHero();

        io.println("Введите hasToothPick:");
        boolean hasToothpick = readHasToothpick();

        io.println("Введите impactSpeed:");
        float impactSpeed = readImpactSpeed();

        io.println("Введите minutesOfWaiting:");
        Long minutesOfWaiting = readMinutesOfWaiting();

        io.println("Введите coordinate X:");
        Integer x = readX();

        io.println("Введите coordinate Y:");
        double y = readY();

        io.println("Введите weaponType:");
        WeaponType weaponType = readWeaponType();

        io.println("Введите mood:");
        Mood mood = readMood();

        io.println("Введите nameCar:");
        String nameCar = readNameCar();

        controller.update(id, name, x, y, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, nameCar);

    }

    private void doRemoveById(String line) {
        int id;
        if (line.length()<14){
            io.println("Вы забыли ввести Id. Введите update еще раз:");
            return;
        }

        String StringId = line.substring(13);

        try {
            id = Integer.parseInt(StringId);

        } catch(NumberFormatException e){
            io.println("Id должно быть целым числом. Введите removeById еще раз:");
            return;
        }

        controller.removeById(id);

    }
}
