package view.commands;

import view.ConsoleUI;

public class ReadFromFile extends Command {
    public ReadFromFile( ConsoleUI consoleUI) {
        super("Выгрузить список из файла", consoleUI);
    }


    @Override
    public void execute() {
        getConsoleUI().readFromFile();
        getConsoleUI().printFromRead();
    }
}