package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/19/17.
 */
public class Prob90 {
    public static <T extends Comparable<T>>BinaryTreeNode<T> findNode(BinaryTreeNode<T> root, T needed) {
        return findNode(root, needed, null);
    }

    private static <T extends Comparable<T>>BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T needed,
                                                                       BinaryTreeNode<T> parent) {
        if (node == null) return null;
        if (needed.compareTo(node.value) == 0)
            return parent;

        BinaryTreeNode<T> foundLeft = findNode(node.left, needed, node);
        if (foundLeft != null)
            return foundLeft;

        return findNode(node.right, needed, node);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTree();
        BinaryTreeNode<Integer> parentOfTwo = findNode(root, 2);
        BinaryTreeNode<Integer> parentOfFour = findNode(root, 4);

        if (parentOfTwo != null) System.out.println(parentOfTwo.value);
        if (parentOfFour != null) System.out.println(parentOfFour.value);
    }
}
