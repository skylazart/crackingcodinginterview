package problems;

import problems.auxiliar.BinaryTreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob123 {
    public static boolean findSumUpToRoot(BinaryTreeNode<Integer> root) {
        return findSumV2(root.right, new HashSet<>(), root.value) || findSumV2(root.left, new HashSet<>(), root.value);
    }

    private static boolean findSum(BinaryTreeNode<Integer> node, Integer targetSum) {
        if (node == null) return false;
        int diff = targetSum - node.value;

        if (findNode(node.left, diff) || findNode(node.right, diff))
            return true;

        return findSum(node.right, targetSum) || findSum(node.left, targetSum);
    }

    public static boolean findNode(BinaryTreeNode<Integer> node, Integer needed) {
        if (node == null) return false;
        if (node.value == needed) return true;
        return findNode(node.left, needed) || findNode(node.right, needed);
    }

    private static boolean findSumV2(BinaryTreeNode<Integer> node, Set<Integer> set, Integer targetSum) {
        if (node == null) return false;

        int diff = targetSum - node.value;
        if (set.contains(diff)) return true;
        set.add(node.value);

        return findSumV2(node.left, set, targetSum) ||
            findSumV2(node.right, set, targetSum);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(2);
        System.out.println(findSumUpToRoot(root));
    }
}
