package view.commands;

import view.ConsoleUI;

public class GetListOfPerson extends Command {
    public GetListOfPerson( ConsoleUI consoleUI) {
        super("Получить список персон", consoleUI);
    }


    @Override
    public void execute() {
        getConsoleUI().getHumanInfo();
    }
}