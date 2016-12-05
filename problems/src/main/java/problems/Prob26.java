package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 12/4/16.
 */

/*
Prob26:
Check if a BST is balanced
 */

public class Prob26 {
    public class CheckBalancedBST <T extends Comparable<T>> {
        private int minHeight = Integer.MAX_VALUE;
        private int maxHeight = Integer.MIN_VALUE;
        private boolean balanced = false;

        public CheckBalancedBST(BinaryTreeNode<T> root) {
            dfs(root, 1);

            if (Math.abs(maxHeight - minHeight) > 1) {
                balanced = false;
            } else {
                balanced = true;
            }
        }

        public boolean isBalanced() {
            return balanced;
        }

        private void dfs(BinaryTreeNode<T> node, int height) {
            if (node == null) {
                minHeight = Math.min(height, minHeight);
                maxHeight = Math.max(height, maxHeight);
                return;
            }

            dfs(node.left, height + 1);
            dfs(node.right, height + 1);
        }
    }

    public void check1() {
        BinaryTreeNode<Integer> balanced = new BinaryTreeNode<>(10);
        balanced.right = new BinaryTreeNode<>(13);
        balanced.right.right = new BinaryTreeNode<>(15);
        balanced.left = new BinaryTreeNode<>(12);

        CheckBalancedBST<Integer> checkBalancedBST = new CheckBalancedBST<>(balanced);
        System.out.println(checkBalancedBST.isBalanced());
    }

    private void check2() {
        BinaryTreeNode<Integer> balanced = new BinaryTreeNode<>(10);
        balanced.right = new BinaryTreeNode<>(20);
        balanced.right.right = new BinaryTreeNode<>(30);

        CheckBalancedBST<Integer> checkBalancedBST = new CheckBalancedBST<>(balanced);
        System.out.println(checkBalancedBST.isBalanced());
    }

    public static void main(String[] args) {
        new Prob26().check1();
        new Prob26().check2();
    }

}
