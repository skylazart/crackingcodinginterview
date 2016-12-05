package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 12/4/16.
 */

/*
Check if a tree is a BST
 */

public class Prob27 {
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean dfs(BinaryTreeNode<Integer> node, Integer min, Integer max) {
        if (node == null) return true;

        if (node.value < min || node.value > max) {
            return false;
        }

        return dfs(node.left, min, node.value) && dfs(node.right, node.value, max);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(8);
        root.left.left = new BinaryTreeNode<>(7);
        root.left.right = new BinaryTreeNode<>(9);

        System.out.println(isBST(root));
    }
}
