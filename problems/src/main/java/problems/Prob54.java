package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/3/17.
 */
public class Prob54 {
    public static <T extends Comparable<T>> boolean isFull(BinaryTreeNode<T> node) {
        if (node.right == null && node.left == null) return true;
        if (node.right == null) return false;
        if (node.left == null) return false;

        return isFull(node.right) && isFull(node.left);
    }

    public static void main(String[] args) {
        System.out.println(isFull(new BinaryTreeNode<Integer>(10)));
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(30);
        System.out.println(isFull(root));
    }
}
