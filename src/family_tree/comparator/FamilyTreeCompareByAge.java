package family_tree.comparator;

import family_tree.TreeNode;
import human.Human;

import java.util.Comparator;

public class FamilyTreeCompareByAge<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {return o1.getBirthDay().compareTo(o2.getBirthDay());}

}
