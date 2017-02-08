package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

/**
 * Created by fsantos on 1/3/17.
 */
public class Prob56 {
    public static <T extends Comparable<T>> boolean isSubTree(BinaryTreeNode<T> t1, BinaryTreeNode<T> sub) {
        // Search in t1 the head of sub
        BinaryTreeNode<T> found = find(t1, sub.value);
        if (found == null) return false;

        // Compare both trees
        return compare(found, sub);
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> find(BinaryTreeNode<T> node, T value) {
        if (node == null) return null;

        // Found
        if (value.compareTo(node.value) == 0) return node;

        BinaryTreeNode<T> foundRight = find(node.right, value);
        if (foundRight != null) return foundRight;
        else return find(node.left, value);
    }

    public static <T extends Comparable<T>> boolean compare(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2) {
        if (t1 == null && t2 == null) return true;
        if (t1.value.compareTo(t2.value) != 0) return false;
        return compare(t1.left, t2.left) && compare(t1.right, t2.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Character> tree1 = new BinaryTreeNode<>('z');
        tree1.right = new BinaryTreeNode<>('e');
        tree1.right.right = new BinaryTreeNode<>('k');

        tree1.left = new BinaryTreeNode<>('x');
        tree1.left.left = new BinaryTreeNode<>('a');
        tree1.left.left.right = new BinaryTreeNode<>('c');
        tree1.left.right = new BinaryTreeNode<>('b');

        BinaryTreeNode<Character> subTree = new BinaryTreeNode<>('x');;
        subTree.left = new BinaryTreeNode<>('a');
        subTree.left.right = new BinaryTreeNode<>('c');
        subTree.right = new BinaryTreeNode<>('b');

        BinaryTreeUtils.printLevelOrder(tree1);
        BinaryTreeUtils.printLevelOrder(subTree);

        System.out.println(isSubTree(tree1, subTree));

    }
}
