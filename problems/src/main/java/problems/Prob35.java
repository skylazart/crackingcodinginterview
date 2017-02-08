package problems;

import problems.auxiliar.BinaryTreeNode;

import java.util.Arrays;

/**
 * Created by fsantos on 12/7/16.
 */
public class Prob35 {
    public static <T extends Comparable<T>> BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T value) {
        if (node == null) return new BinaryTreeNode<T>(value);
        int cmp = value.compareTo(node.value);

        if (cmp > 0) node.right = insert(node.right, value);
        else node.left = insert(node.left, value);

        return node;
    }

    public static <T extends Comparable<T>> void findLeftMost(BinaryTreeNode<T> node) {
        System.out.println(findLeftMost(node, 0));
    }

    public static <T extends Comparable<T>> int findLeftMost(BinaryTreeNode<T> node,
                                                             int counter) {
        if (node == null) {
            return counter;
        }

        return Math.max(findLeftMost(node.left, counter + 1),
                findLeftMost(node.right, counter - 1));
    }


    public static class FindLeftMost<T extends Comparable<T>> {
        private int max = Integer.MIN_VALUE;
        private BinaryTreeNode<T> found = null;

        public FindLeftMost(BinaryTreeNode<T> root) {
            dfs(root, 0);
        }

        private void dfs(BinaryTreeNode<T> node, int counter) {
            if (node.left == null && node.right == null) {
                if (counter > max) {
                    max = counter;
                    found = node;
                }

                return;
            }

            if (node.left != null) dfs(node.left, counter + 1);
            if (node.right != null) dfs(node.right, counter - 1);
        }

        public BinaryTreeNode<T> getLeftMost() {
            return found;
        }
    }

    public static class FindRightMost<T extends Comparable<T>> {
        private int max = Integer.MIN_VALUE;
        private BinaryTreeNode<T> found = null;

        public FindRightMost(BinaryTreeNode<T> root) {
            dfs(root, 0);
        }

        private void dfs(BinaryTreeNode<T> node, int counter) {
            if (node.left == null && node.right == null) {
                if (counter > max) {
                    max = counter;
                    found = node;
                }

                return;
            }

            if (node.right != null) dfs(node.right, counter + 1);
            if (node.left != null) dfs(node.left, counter - 1);
        }

        public BinaryTreeNode<T> getRightMost() {
            return found;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = null;

        for (Integer x : Arrays.asList(10, 9, 15, 14, 13, 11, 16)) {
            root = insert(root, x);
        }

        FindLeftMost<Integer> findLeftMost = new FindLeftMost<>(root);
        FindRightMost<Integer> findRightMost = new FindRightMost<>(root);

        BinaryTreeNode<Integer> foundLeft = findLeftMost.getLeftMost();
        BinaryTreeNode<Integer> foundRight = findRightMost.getRightMost();
        if (foundLeft != null)
            System.out.println(foundLeft.value);
        if (foundRight != null)
            System.out.println(foundRight.value);
    }

}
