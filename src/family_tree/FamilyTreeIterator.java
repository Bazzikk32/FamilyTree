package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeNode<E>> implements Iterator<E> {

    private int index;
    private List<E> humanList;

    public FamilyTreeIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
