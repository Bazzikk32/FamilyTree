import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import service.HumanBuilder;
import service.Service;
import writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        service.addHuman("Миша",Gender.Male, LocalDate.of(1991,02,01),null);
        service.addHuman("Саша",Gender.Female, LocalDate.of(1992,03,01),null);
        service.addHuman("Даша",Gender.Female, LocalDate.of(1993,04,01),null);
        service.addHuman("Витя",Gender.Male, LocalDate.of(1994,05,01),null);
        service.addHuman("Катя",Gender.Female, LocalDate.of(1995,06,01),null);
        service.addHuman("Гриша",Gender.Male, LocalDate.of(1996,07,01),null);
        System.out.println(service.getHumanListInfo());
        //service.save(service.getHumanListInfo(), service.filePath);

        System.out.println("Сортировка по возрасту:\n");
        service.sortByAge();
        System.out.println(service.getHumanListInfo());
        System.out.println("Сортировка по имени:\n");
        service.sortByName();
        System.out.println(service.getHumanListInfo());

        service.save(service.getHumanListInfo(), service.filePath);

        System.out.println("Список из файла\n");
        FamilyTree familyTree = service.read(service.filePath);
        System.out.println(familyTree);






//    }
//
//
//    static FamilyTree testTree(){
//        FamilyTree familyTree = new FamilyTree();
//
//        Human Sasha = new Human("Sasha", Gender.Female, LocalDate.of(1991,05,02), deathDate);
//        Human Alex = new Human("Alex",Gender.Male, LocalDate.of(1995,05,02), deathDate);
//        Human Kostya = new Human("Kostya",Gender.Male, LocalDate.of(1956,05,02), deathDate);
//        Human Masha = new Human("Maria",Gender.Female, LocalDate.of(1957,05,02), deathDate);
//        Human Dima = new Human("Dmitriy", Gender.Female, LocalDate.of(2007,05,02), deathDate);
//        Human Sveta = new Human("Svetlana",Gender.Male, LocalDate.of(1965,05,02), deathDate);
//        familyTree.add(Dima);
//        familyTree.add(Sveta);
//        familyTree.add(Sasha);
//        familyTree.add(Alex);
//        Sasha.addParents(Kostya);
//        Sasha.addParents(Masha);
//        Alex.addParents(Kostya);
//        Alex.addParents(Masha);
//        return familyTree;
    }
}
