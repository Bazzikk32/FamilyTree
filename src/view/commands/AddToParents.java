package view.commands;

import view.ConsoleUI;

public class AddToParents extends Command {
    public AddToParents( ConsoleUI consoleUI) {
        super("Добавить родителя к персоне", consoleUI);
    }


    @Override
    public void execute() {
        getConsoleUI().AddToParents();
    }
}