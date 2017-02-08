package problems;

/**
 * Created by fsantos on 12/5/16.
 */

import problems.auxiliar.BinaryTreeNode;

/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value
 * (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */

public class Prob33 {
    class PathsUpToSum {
        private int total;
        private int needed;

        public PathsUpToSum(BinaryTreeNode<Integer> root, int needed) {
            total = 0;
            this.needed = needed;
            dfs(root);
        }

        private void dfs(BinaryTreeNode<Integer> node) {
            if (node == null) return;

            checkSum(node, node.value);

            dfs(node.left);
            dfs(node.right);
        }

        private void checkSum(BinaryTreeNode<Integer> node, int sum) {
            if (sum == needed) {
                total++;
                return;
            }

            if (node.left != null) checkSum(node.left, sum + node.left.value);
            if (node.right != null) checkSum(node.right, sum + node.right.value);
        }

        public int getTotal() {
            return total;
        }
    }

    public void run() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(11);
        root.right.left = new BinaryTreeNode<>(10);
        root.right.left.right = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(7);
        root.left.right.left = new BinaryTreeNode<>(1);

        PathsUpToSum pathsUpToSum = new PathsUpToSum(root, 21);

        System.out.println(pathsUpToSum.getTotal());
    }

    public static void main(String[] args) {
        new Prob33().run();
    }
}
