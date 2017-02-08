package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob104 {
    public static <T extends Comparable<T>> boolean find(BinaryTreeNode<T> node, T wanted) {
        if (node == null) return false;

        if (node.value.compareTo(wanted) == 0) return true;

        return find(node.right, wanted) || find(node.left, wanted);
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> findLcaBinaryTree(BinaryTreeNode<T> node, T v1, T v2) {
        if (node == null) return null;
        boolean foundRight = find(node.right, v1) || find(node.right, v2);
        boolean foundLeft = find(node.left, v1) || find(node.left, v2);

        if (foundRight && foundLeft)
            return node;

        if (foundRight) return findLcaBinaryTree(node.right, v1, v2);
        else return findLcaBinaryTree(node.left, v1, v2);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTree();
        BinaryTreeNode<Integer> lca = findLcaBinaryTree(root, 4, 6);
        System.out.println(lca.value);
    }
}
