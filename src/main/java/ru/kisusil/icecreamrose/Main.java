package ru.kisusil.icecreamrose;

import ru.kisusil.icecreamrose.controller.Controller;
import ru.kisusil.icecreamrose.controller.MyController;
import ru.kisusil.icecreamrose.model.ApplicationContext;
import ru.kisusil.icecreamrose.model.HumanBeingCreator;
import ru.kisusil.icecreamrose.model.HumanBeingRepository;
import ru.kisusil.icecreamrose.model.magic.*;
import ru.kisusil.icecreamrose.view.MyApplication;
import ru.kisusil.icecreamrose.view.Console;
import ru.kisusil.icecreamrose.view.IO;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args){
        IO io = new Console(System.in, System.out);
        io.println("Здравствуйте");
        io.println("Программа запущена");
        io.println("");

        HumanBeingRepository humanBeingRepository = new HumanBeingRepository();
        HumanBeingCreator humanBeingCreator = new HumanBeingCreator();

        ApplicationContext applicationContext = new ApplicationContext(humanBeingCreator, humanBeingRepository);
        Controller controller = new MyController(applicationContext);

        Map <String, Magic> magics = new HashMap<>();
        magics.put("add", new AddMagic(applicationContext));
        magics.put("clear", new ClearMagic(applicationContext));
        magics.put("executeScript", new ExecuteScriptMagic(controller));
        magics.put("help", new HelpMagic(applicationContext));
        magics.put("info", new InfoMagic(applicationContext));
        magics.put("removeById", new RemoveByIdMagic(applicationContext));
        magics.put("removeLower", new RemoveLowerMagic(applicationContext));
        magics.put("save", new SaveMagic(applicationContext));
        magics.put("show", new ShowMagic(applicationContext));
        magics.put("update", new UpdateMagic(applicationContext));
        magics.put("addIfMax", new AddIfMaxMagic (applicationContext));
        magics.put("countByMood", new CountByMoodMagic(applicationContext));
        magics.put("filterGreaterThanMood", new FilterGreaterThanMoodMagic (applicationContext));
        magics.put("printAscending", new PrintAscendingMagic(applicationContext));

        applicationContext.setMagics(magics);

        MyApplication myApplication = new MyApplication(io, controller);

        myApplication.start();
    }
}
