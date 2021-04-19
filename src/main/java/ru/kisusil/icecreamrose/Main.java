package ru.kisusil.icecreamrose;

import ru.kisusil.icecreamrose.controller.Controller;
import ru.kisusil.icecreamrose.controller.MyController;
import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.HumanBeingCreator;
import ru.kisusil.icecreamrose.model.HumanBeingRepository;
import ru.kisusil.icecreamrose.view.MyApplication;
import ru.kisusil.icecreamrose.view.Console;
import ru.kisusil.icecreamrose.view.IO;

public class Main {
    public static void main (String[] args){
        IO io = new Console(System.in, System.out);
        io.println("Здравствуйте");
        io.println("Программа запущена");
        io.println("");

        HumanBeingRepository humanBeingRepository = new HumanBeingRepository();
        HumanBeingCreator humanBeingCreator = new HumanBeingCreator();
        ApplicationContext applicationContext = new ApplicationContext(humanBeingCreator, humanBeingRepository, io);
        Controller controller = new MyController(applicationContext);
        MyApplication myApplication = new MyApplication(io, applicationContext, controller);

        myApplication.start();
    }
}
