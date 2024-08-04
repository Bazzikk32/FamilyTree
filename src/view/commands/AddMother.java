package view.commands;

import view.ConsoleUI;

public class AddMother extends Command {
    public AddMother(ConsoleUI consoleUI) {
        super("Добавить мать", consoleUI);
    }


    @Override
    public void execute() {
        getConsoleUI().addMother();
    }
}