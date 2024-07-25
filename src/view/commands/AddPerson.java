package view.commands;

import view.ConsoleUI;

public class AddPerson extends Command {
    public AddPerson( ConsoleUI consoleUI) {
        super("Добавить персону", consoleUI);
    }


    @Override
    public void execute() {
    getConsoleUI().addHuman();
    }
}
