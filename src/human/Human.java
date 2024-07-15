package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDay, LocalDate deathDate,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDay) {

        this(name, gender, birthDay, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDay, Human father,  Human mother) {
        this(name, gender,birthDay, null, father,mother);
    }


    public Gender getGender() {
        return gender;
    }

    public  boolean addChild (Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParents (Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return  true;
        }
        return false;

    }

    public Human getFather (){
        for (Human parent : parents) {
            if (parent.getGender()==Gender.Male){
                return parent;
            }

        }
        return null;
    }

    public Human getMother (){
        for (Human parent : parents) {
            if (parent.getGender()==Gender.Female){
                return parent;
            }

        }
        return null;
    }

    private int getPeriod(LocalDate birthDay, LocalDate deathDate){
        Period diff = Period.between(birthDay, deathDate);
        return diff.getYears();

    }

    public int getAge (){
        if (deathDate == null){
            return getPeriod(birthDay, LocalDate.now());
        }
        else {
            return getPeriod(birthDay,deathDate);
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size()!=0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append (", ");
                res.append (children.get(i).getName());

            }
        } else {
            res.append("Отсутствуют");
        }
        return res.toString();
    }
    public String toString () {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildren());
        return sb.toString();
    }
}

