package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 2/12/17.
 */
public class Prob158 {
    public static <T extends Comparable<T>> int diffHeight(BinaryTreeNode<T> root, T a, T b) {
        return Math.abs(findHeight(root, a, 1) - findHeight(root, b, 1));
    }

    private static <T extends Comparable<T>> int findHeight(BinaryTreeNode<T> node, T needed, int height) {
        if (node == null) return height;
        if (node.value == needed) return height;
        return Math.max(findHeight(node.left, needed, height + 1), findHeight(node.right, needed, height + 1));
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(3);

        System.out.println(diffHeight(root, 1, 3));
    }
}
