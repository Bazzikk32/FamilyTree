package model.family_tree.comparator;

import model.family_tree.TreeNode;

import java.util.Comparator;

public class FamilyTreeCompareByAge<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {return o1.getBirthDay().compareTo(o2.getBirthDay());}

}
