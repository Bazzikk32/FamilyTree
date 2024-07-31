package model.service;


import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;
import model.writer.Writable;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {

    private FamilyTree familyTree;
    private HumanBuilder humanBuilder;
    private Writable writable;
    public String filePath = "src/model/writer/tree.txt";
    private Human human;

    public Service() {


        familyTree = new FamilyTree<Human>();
        humanBuilder = new HumanBuilder();
        writable = new FileHandler();


    }

    public void addHuman (String name, Gender gender, LocalDate birthDay, LocalDate deathDate){
        Human human1 = humanBuilder.build(name, gender, birthDay, deathDate);
        familyTree.add(human1);
    }

    public String getHumanListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список древа:\n");
        for (Object human: familyTree){
            sb.append(human);
            sb.append("\n");

        }
        return sb.toString();
    }

    public void sortByName (){
        familyTree.sortByName();
    }

    public void sortByAge (){
        familyTree.sortByAge();
    }

    public FamilyTree read (String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    public void save (String getHumanList, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save((Serializable) familyTree, this.filePath);
    }

    public void addToParent (){
        familyTree.addToParent(human);
    }

    public Human getById (int id){
       return (Human) familyTree.getById(id);
    }


}
