import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import service.Service;
import writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        FamilyTree familyTree = testTree();
        System.out.println(familyTree);


//        String filePath = "src/writer/tree.txt";
//
//        FamilyTree familyTree = read(filePath);
//        System.out.println(familyTree);
//
//        save(familyTree, filePath);

        System.out.println(familyTree.getFamilyListInfo());

        System.out.println("Сортировка по возрасту\n");
        familyTree.sortByAge();
        System.out.println(familyTree);

        System.out.println("Сортировка по имени\n");
        familyTree.sortByName();
        System.out.println(familyTree);




    }
    static  FamilyTree read (String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    static  void save (FamilyTree familyTree,String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save((Serializable) familyTree, filePath);
    }

    static FamilyTree testTree(){
        FamilyTree familyTree = new FamilyTree();
        Human Sasha = new Human("Sasha", Gender.Female, LocalDate.of(1991,05,02));
        Human Alex = new Human("Alex",Gender.Male, LocalDate.of(1995,05,02));
        familyTree.add(Sasha);
        familyTree.add(Alex);
        Human Dima = new Human("Dmitriy", Gender.Female, LocalDate.of(2007,05,02));
        Human Sveta = new Human("Svetlana",Gender.Male, LocalDate.of(1965,05,02));
        familyTree.add(Dima);
        familyTree.add(Sveta);
        return familyTree;
    }
}
