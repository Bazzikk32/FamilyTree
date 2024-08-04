package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SaveToFile extends Command {
    public SaveToFile( ConsoleUI consoleUI) {
        super("Сохраннить в файл", consoleUI);
    }


    @Override
    public void execute() throws IOException {
        getConsoleUI().saveToFile();
    }
}