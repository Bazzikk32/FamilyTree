package view;

import model.human.Gender;
import presenter.Presenter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View, Serializable {

    private Scanner scanner;
    private Presenter presenter;
    private LocalDate deathDate;
    Gender gender;
    private boolean work = true;
    private MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();

            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }

    }

    public void printFromRead() {
        presenter.printFromRead();
    }

    public void readFromFile() {
        presenter.readFromFile();
    }

    public void saveToFile() {
        presenter.addToFile();
    }


    public void sortByAge() {
        presenter.sortByAge();
    }




    public void finish() {
        System.out.println("See you again...");
        work = false;
    }

    public void getHumanInfo() {
        presenter.getHumanList();
    }

    public void addHuman() {
        System.out.println("Введите имя персоны");
        String name = scanner.nextLine();
        System.out.println("Введите пол персоны, если мужчина: 1, если женщина: 2");
        String genderChoice = scanner.nextLine();
        switch (genderChoice){
            case "1": gender = Gender.Male;
            break;
            case "2": gender = Gender.Female;
            break;
            default:
                System.out.println("Вы ввели некорректное значение, попробуйте еще раз");
        }
        System.out.println("Введите дату рождения в формате yyyy-MM-dd");
        String dateOfBirthStr = scanner.nextLine();
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth
                = LocalDate.parse(dateOfBirthStr, formatter);

        System.out.println("Если человек жив введите: 1, если уже мертв введите:2");
        String liveOrNot = scanner.nextLine();
        switch (liveOrNot){
            case "1":
                deathDate = null;
            break;
            case "2": System.out.println("Введите дату смерти в формате yyyy-MM-dd");
                String dateOfDeathStr = scanner.nextLine();
                deathDate = LocalDate.parse(dateOfDeathStr);
                break;
            default:
                System.out.println("Вы ввели некорректное значение, попробуйте еще раз");
        }


        presenter.addHuman(name, gender, dateOfBirth, deathDate);
    }


    @Override
    public void printAnswer(String answer) {

        System.out.println(answer);

    }
}
