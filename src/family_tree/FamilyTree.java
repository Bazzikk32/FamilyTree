package family_tree;

import family_tree.comparator.FamilyTreeCompareByAge;
import family_tree.comparator.FamilyTreeCompareByName;
import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable <Human>{
    private long humansID;
    private List <E> humanlist;

    public FamilyTree() {this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanlist) {
        this.humanlist = humanlist;
    }

    public void addToParent(E human){
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(E human){
        for (E child : human.getChildren()) {
            child.addParents(human);
        }
    }

    public boolean add (E human){
        if (human == null){
            return false;
        }
        if (!humanlist.contains(human)) {
            humanlist.add(human);
            human.setId(humansID++);

            addToParent (human);
            addToChildren (human);
            return  true;
        }
        return false;
    }

    public List<E> getByName (String name){
        List<E> res = new ArrayList<>();
        for (E human : humanlist) {
            if(human.getName().equals(name)){
                res.add(human);
            }
            
        }return res;
    }

    public String toString () {
        return getInfo();
    }

    public String getInfo (){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanlist.size());
        sb.append(" объектов: \n");
        for (E human : humanlist) {
            sb.append(human);
            sb.append("\n");
            
        }
        return sb.toString();
    }

    public String getFamilyListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список древа:\n");
        for (E human : humanlist ) {
            sb.append(human);
            sb.append("\n");

        }

        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() { return new FamilyTreeIterator(humanlist);}

    public void sortByName (){ Collections.sort(humanlist, new FamilyTreeCompareByName<>());}

    public void sortByAge (){
        Collections.sort(humanlist, new FamilyTreeCompareByAge<>());
    }
}
