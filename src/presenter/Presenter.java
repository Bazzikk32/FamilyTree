package presenter;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.service.Service;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private FamilyTree familyTree;
    private Service service;
    private View view;
    String filePath = "C:\\JAVA\\LESSONS\\FamilyTree\\src\\model\\writer\\tree.txt";


    public Presenter(View view) {
        this.view = view;
        service = new Service();
        //this.familyTree = familyTree;
        familyTree=new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth, LocalDate deathDate) {
        service.addHuman(name, gender, dateOfBirth, deathDate);
        getHumanList();
    }

    public void getHumanList() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByAge(){
        service.sortByAge();
        getHumanList();
    }

    public void addToFile() {
        service.save(service.getHumanListInfo(), service.filePath);

    }

    public void readFromFile() {
        service.read(service.filePath);
    }

    public void printFromRead() {
        FamilyTree tree = service.read(service.filePath);
        System.out.println(tree);
    }


}
