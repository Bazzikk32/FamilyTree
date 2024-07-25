package view.commands;

import view.ConsoleUI;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }
public String getDescriprion() {
    return description;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
