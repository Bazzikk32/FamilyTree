package service;


import family_tree.FamilyTree;
import family_tree.comparator.FamilyTreeCompareByAge;
import family_tree.comparator.FamilyTreeCompareByName;
import human.Gender;
import human.Human;
import writer.FileHandler;
import writer.Writable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service  {

    private FamilyTree familyTree;
    private HumanBuilder humanBuilder;
    private Writable writable;

    public Service() {
        familyTree = new FamilyTree();
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
        for (Human human: familyTree){
            sb.append(human);
            sb.append("\n");

        }
        return sb.toString();
    }

    public void sortByName2 (){ Collections.sort();

    public void sortByAge (){
        Collections.sort(familyTree, new FamilyTreeCompareByAge());
    }


}
