package view.commands;

import view.ConsoleUI;

public class SaveToFile extends Command {
    public SaveToFile( ConsoleUI consoleUI) {
        super("Сохраннить в файл", consoleUI);
    }


    @Override
    public void execute() {
        getConsoleUI().saveToFile();
    }
}