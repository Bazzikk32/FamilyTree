package service;


import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;
import writer.Writable;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {

    private FamilyTree familyTree;
    private HumanBuilder humanBuilder;
    private Writable writable;
    public String filePath = "src/writer/tree.txt";

    public Service() {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
        writable = new FileHandler();
        String filePath = "src/writer/tree.txt";
    }

    public void addHuman (String name, Gender gender, LocalDate birthDay, LocalDate deathDate){
        Human human1 = humanBuilder.build(name, gender, birthDay, deathDate);
        familyTree.add(human1);
    }

    public String getHumanListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список древа:\n");
        for (Human human: familyTree){
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

    public void save (String humanListInfo, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save((Serializable) familyTree, this.filePath);
    }


}
