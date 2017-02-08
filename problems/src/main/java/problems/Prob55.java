package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/3/17.
 */
public class Prob55 {
    public static <T extends Comparable<T>>BinaryTreeNode<T> LCA(BinaryTreeNode<T> node,
                                                                 T n1, T n2) {
        boolean found = find(node, n1) | find(node, n2);
        if (!found) return null;

        int cmp1 = n1.compareTo(node.value);
        int cmp2 = n2.compareTo(node.value);

        if (cmp1 < 0 && cmp2 > 0) return node;
        if (cmp1 > 0 && cmp2 > 0) return LCA(node.right, n1, n2);
        else return LCA(node.left, n1, n2);
    }

    private static <T extends Comparable<T>> boolean find(BinaryTreeNode<T> node, T wanted) {
        if (node == null) return false;

        int cmp = wanted.compareTo(node.value);
        if (cmp == 0) return true;
        if (cmp > 0) return find(node.right, wanted);

        return find(node.left, wanted);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.left.right = new BinaryTreeNode<>(18);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(6);

        BinaryTreeNode<?> lca = LCA(root, 4, 6);
        if (lca != null)
            System.out.println(lca.value);
    }
}
