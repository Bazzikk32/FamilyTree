package view.commands;

import view.ConsoleUI;

public class AddFather extends Command {
    public AddFather(ConsoleUI consoleUI) {
        super("Добавить отца", consoleUI);
    }


    @Override
    public void execute() {
        getConsoleUI().addFather();
    }
}