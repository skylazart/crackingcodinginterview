package problems.auxiliar;

/**
 * Created by fsantos on 12/1/16.
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    private final T value;
    private BinaryTreeNode<T> left;

    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    public T getValue() {
        return value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
