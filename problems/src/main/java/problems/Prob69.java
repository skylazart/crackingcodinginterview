package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/6/17.
 */
public class Prob69 {
    public static boolean checkSum(BinaryTreeNode<Integer> root, int sum) {
        return dfs(root, sum);
    }

    private static boolean dfs(BinaryTreeNode<Integer> node, int needed) {
        if (node == null) return false;
        int sum = sum(node);
        if (sum == needed) return true;
        return dfs(node.right, needed) || dfs(node.left, needed);
    }

    private static int sum(BinaryTreeNode<Integer> node) {
        if (node == null) return 0;
        return node.value + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(5);
        System.out.println(checkSum(root, 12));
    }
}
