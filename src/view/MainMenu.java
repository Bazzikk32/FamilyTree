package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddPerson(consoleUI));
        commands.add(new GetListOfPerson(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SaveToFile(consoleUI));
        commands.add(new ReadFromFile(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список команд:\n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commands.get(i).getDescriprion());
            sb.append("\n");

        } return sb.toString();
    }
    public void execute (int choice){
Command command = commands.get((choice-1));
command.execute();
    }

    public int size() {
        return commands.size();
    }
}
