package service;

import human.Gender;
import human.Human;

import java.time.LocalDate;

public class HumanBuilder {

    private int genId;

    public HumanBuilder(){

    }
    public Human build (String name, Gender gender, LocalDate birthDay, LocalDate deathDate){
        return new Human(name, gender, birthDay, deathDate, genId++);
    }

//    public Human build (String name, Gender gender, LocalDate birthDay){
//        return new Human(name, gender, birthDay, genId++);
//    }
}
