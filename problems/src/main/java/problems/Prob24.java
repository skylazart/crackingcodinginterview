package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 12/2/16.
 */
public class Prob24 {
    public static <T extends Comparable<T>> BinaryTreeNode<T> makeMinimalTree(T[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;
        int mid = findMidPoint(left, right);

        BinaryTreeNode<T> root = new BinaryTreeNode<T>(sortedArray[mid]);

        makeMinimalTree(root, sortedArray, left, mid - 1);
        makeMinimalTree(root, sortedArray, mid + 1, right);

        return root;
    }

    public static <T extends Comparable<T>> void makeMinimalTree(BinaryTreeNode<T> root, T[] sortedArray, int left, int right) {
        if (left > right) return;

        int mid = findMidPoint(left, right);
        insertBst(root, sortedArray[mid]);

        makeMinimalTree(root, sortedArray, left, mid - 1);
        makeMinimalTree(root, sortedArray, mid + 1, right);
    }

    private static <T extends Comparable<T>> BinaryTreeNode<T> insertBst(BinaryTreeNode<T> node, T value) {
        if (node == null) return new BinaryTreeNode<>(value);
        if (value.compareTo(node.value) > 0) node.right = insertBst(node.right, value);
        else node.left = insertBst(node.left, value);

        return node;
    }

    private static int findMidPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6, 7};
        makeMinimalTree(arr);
    }
}
