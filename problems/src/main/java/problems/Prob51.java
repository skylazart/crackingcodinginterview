package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/3/17.
 */
public class Prob51 {
    public static <T extends Comparable<T>> int minHeight(BinaryTreeNode<T> root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    private static <T extends Comparable<T>> int dfs(BinaryTreeNode<T> node, int height) {
        if (node == null) return height;
        return Math.min(dfs(node.right, height + 1), dfs(node.left, height + 1));
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(3);
        root.left = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);

        System.out.println(minHeight(root));
    }
}
