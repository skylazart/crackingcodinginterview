package problems;

/**
 * Created by fsantos on 12/5/16.
 */

import problems.auxiliar.BinaryTreeNode;

/**
 * Print each node within a binary tree only when the sum of right nodes are greater then the sum of left nodes
 */

/*
                        10
                 5                20
            4       7        8         40


node = 10, sum = 0
    sumRight = 20, sum = 10
        sumRight = 40, sum = 30
 */

public class Prob32 {
    public static int printOnly(BinaryTreeNode<Integer> node) {
        if (node == null) return 0;
        if (node.right == null && node.left == null) {
            return node.value;
        }

        int sumLeft = printOnly(node.left);
        int sumRight = printOnly(node.right);

        if (sumLeft < sumRight) {
            System.out.println(node.value);
        }

        return node.value + sumLeft + sumRight;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(20);
        root.right.right = new BinaryTreeNode<>(40);
        root.right.left = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(5);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(7);

        printOnly(root);
    }
}
