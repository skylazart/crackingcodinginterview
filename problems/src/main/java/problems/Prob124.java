package problems;

import problems.auxiliar.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob124 {
    public static int findLongestConsecutiveSequence(BinaryTreeNode<Integer> root) {
        return Math.max(dfs(root.left, root, 1), dfs(root.right, root, 1));
    }

    private static int dfs(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> prev, int count) {
        if (node == null) return count;
        if (node.value - prev.value == 1) {
            return Math.max(dfs(node.left, node, count + 1), dfs(node.right, node, count + 1));
        }

        return Math.max(dfs(node.left, node, 1), dfs(node.right, node, 1));
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);
        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(9);
        root.right.left.right = new BinaryTreeNode<>(4);
        root.left = new BinaryTreeNode<>(2);
        root.right.left.right.right = new BinaryTreeNode<>(5);

        System.out.println(findLongestConsecutiveSequence(root));
    }
}
