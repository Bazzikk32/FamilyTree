package presenter;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private Service service;
    private View view;



    public Presenter(View view) {
        this.view = view;
        service = new Service();

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

    public void sortByName(){
        service.sortByName();
        getHumanList();
    }


    public void addToParent() {
        service.addToParent();
    }

    public Human getById(int id){   // вернуть по id
        return service.getById(id);
    }
}
