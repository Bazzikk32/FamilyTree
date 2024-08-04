package presenter;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.View;

import java.io.IOException;
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
    public void addToFile(String file) throws IOException {service.save(file);}
    public void readFromFile(String file) throws IOException, ClassNotFoundException {service.read(file);}


    public void sortByName(){
        service.sortByName();
        getHumanList();
    }
    public void addMother(Human human,Human mother) {
        service.addMother(human,mother);
    }
    public void addFather(Human human,Human father) {
        service.addFather(human,father);
    }


    public void addToParent(Human human, Human parent) {
        service.addToParent(human, parent);
    }

    public Human getById(int id){   // вернуть по id
        return service.getById(id);
    }
}
