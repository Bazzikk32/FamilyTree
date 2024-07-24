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


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work){
            System.out.println("Выберете действие:");
            System.out.println("1. Создать человека");
            System.out.println("2. Список персон");
            System.out.println("3. Добавить родителя");
            System.out.println("4. Сортировать по возрасту");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Прочитать из файла");
            System.out.println("7. Завершение работы");

            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    addHuman();
                    break;
                case "2":
                    getHumanInfo();
                    break;
                case "3":

                    break;
                case "4":
                    sortByAge();
                    break;
                case "5":
                    saveToFile();
                    break;
                case "6":
                    readFromFile();
                    printFromRead();
                    break;
                case "7":
                    finish ();
                    break;
                default:
                    System.out.println("Введены неверные данные");
            }


        }

    }

    private void printFromRead() {
        presenter.printFromRead();
    }

    private void readFromFile() {
        presenter.readFromFile();
    }

    private void saveToFile() {
        presenter.addToFile();
    }


    private void sortByAge() {
        presenter.sortByAge();
    }




    private void finish() {
        System.out.println("See you again...");
        work = false;
    }

    private void getHumanInfo() {
        presenter.getHumanList();
    }

    private void addHuman() {
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
