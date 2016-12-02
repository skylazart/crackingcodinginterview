package problems.auxiliar;

/**
 * Created by fsantos on 12/1/16.
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    public final T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }
}
