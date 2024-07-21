package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    long setId(long l);

    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParents(T human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDay();
    List<T> getParents();
    List<T> getChildren();
    }
