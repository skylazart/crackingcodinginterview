package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

import static problems.Prob56.find;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob103 {
    public static <T extends Comparable<T>> BinaryTreeNode<T> lcaFromBST(BinaryTreeNode<T> root, T v1, T v2) {
        if (!find(root, v1) || !find(root, v2))
            return null;

        return lcaBST(root, v1, v2);
    }

    private static <T extends Comparable<T>> BinaryTreeNode<T> lcaBST(BinaryTreeNode<T> node, T v1, T v2) {
        boolean foundRight = v1.compareTo(node.value) > 0 || v2.compareTo(node.value) > 0;
        boolean foundLeft = v1.compareTo(node.value) < 0 || v2.compareTo(node.value) < 0;
        if (foundRight && foundLeft)
            return node;

        if (foundRight) return lcaFromBST(node.right, v1, v2);
        else return lcaFromBST(node.left, v1, v2);
    }

    public static <T extends Comparable<T>> boolean find(BinaryTreeNode<T> node, T wanted) {
        if (node == null) return false;

        int cmp = wanted.compareTo(node.value);
        if (cmp == 0)
            return true;

        if (cmp > 0) return find(node.right, wanted);
        else return find(node.left, wanted);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBST();
        BinaryTreeNode<Integer> lca = lcaFromBST(root, 6, 9);
        if (lca != null) System.out.println(lca.value);
    }
}
