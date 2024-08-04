package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class ReadFromFile extends Command {
    public ReadFromFile( ConsoleUI consoleUI) {
        super("Выгрузить список из файла", consoleUI);
    }


    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsoleUI().readFromFile();

    }
}