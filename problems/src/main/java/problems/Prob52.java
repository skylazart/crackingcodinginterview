package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/3/17.
 */
public class Prob52 {
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        return dfs(root, 0);
    }

    private static int dfs(BinaryTreeNode<Integer> node, int acc) {
        if (node == null) return 0;

        int maxLeft = dfs(node.left, acc);
        int maxRight = dfs(node.right, acc);

        int maxSingle = Math.max(Math.max(maxLeft, maxRight) + node.value, node.value);
        int maxTop = Math.max(maxSingle, maxLeft + maxRight + node.value);

        return Math.max(maxSingle, maxTop);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(20);
        root.left.right = new BinaryTreeNode<>(1);

        root.right = new BinaryTreeNode<>(10);
        root.right.right = new BinaryTreeNode<>(-25);
        root.right.right.right = new BinaryTreeNode<>(4);
        root.right.right.left = new BinaryTreeNode<>(3);

        System.out.println(maxPathSum(root));

    }
}
