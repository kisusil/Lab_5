package ru.kisusil.icecreamrose;

import ru.kisusil.icecreamrose.controller.Controller;
import ru.kisusil.icecreamrose.controller.MyController;
import ru.kisusil.icecreamrose.model.*;
import ru.kisusil.icecreamrose.model.command.*;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;
import ru.kisusil.icecreamrose.view.MyApplication;
import ru.kisusil.icecreamrose.view.Console;
import ru.kisusil.icecreamrose.view.IO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args){
        IO io = new Console(System.in, System.out);
        String collectionFileName = System.getenv("fileName");

        if (collectionFileName == null) {
            io.println("Переменная окружения не задана");
            return;
        }

        CollectionSaver collectionSaver = new CollectionSaver(collectionFileName);
        CollectionLoader collectionLoader = new CollectionLoader(collectionFileName, io);
        Repository repository;
        try {
            repository = collectionLoader.load();
        } catch (CollectoinLoaderException e) {
            io.println(e.getMessage());
            return;
        }

        io.println("Здравствуйте");
        io.println("Программа запущена");
        io.println("");

        List<HumanBeing> humanBeings = repository.getAll();
        int maxExistedId = 0;

        for (HumanBeing humanBeing : humanBeings) {
            if (humanBeing.getId() > maxExistedId) {
                maxExistedId = humanBeing.getId();
            }
        }

        HumanBeingBuilder humanBeingBuilder = new MyHumanBeingBuilder(maxExistedId + 1);

        ApplicationContext applicationContext = new ApplicationContext(humanBeingBuilder, repository, collectionSaver);
        Controller controller = new MyController(applicationContext);

        Map <String, Command> commands = new HashMap<>();
        commands.put("add", new AddCommand(applicationContext));
        commands.put("clear", new ClearCommand(applicationContext));
        commands.put("executeScript", new ExecuteScriptCommand(controller));
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(applicationContext));
        commands.put("removeById", new RemoveByIdCommand(applicationContext));
        commands.put("removeLower", new RemoveLowerCommand(applicationContext));
        commands.put("save", new SaveCommand(applicationContext));
        commands.put("show", new ShowCommand(applicationContext));
        commands.put("update", new UpdateCommand(applicationContext));
        commands.put("addIfMax", new AddIfMaxCommand(applicationContext));
        commands.put("countByMood", new CountByMoodCommand(applicationContext));
        commands.put("filterGreaterThanMood", new FilterGreaterThanMoodCommand(applicationContext));
        commands.put("printAscending", new PrintAscendingCommand(applicationContext));

        applicationContext.setCommands(commands);

        MyApplication myApplication = new MyApplication(io, controller);

        myApplication.start();
    }
}
