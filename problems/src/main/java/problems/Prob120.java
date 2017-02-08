package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob120 {
    public static <T extends Comparable<T>> void printNodesWithKLeaves(BinaryTreeNode<T> root, int K) {
        dfsPost(root, K);
    }

    private static <T extends Comparable<T>> int dfsPost(BinaryTreeNode<T> node, int K) {
        if (node.right == null && node.left == null) return 1;
        int totalLeaves = dfsPost(node.left, K) + dfsPost(node.right, K);

        if (totalLeaves == K)
            System.out.println(node.value);

        return totalLeaves;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(5);
        root.left.left.left = new BinaryTreeNode<>(9);
        root.left.left.right = new BinaryTreeNode<>(10);
        root.left.right = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(7);
        root.right.left.left = new BinaryTreeNode<>(12);
        root.right.left.right = new BinaryTreeNode<>(11);
        root.right.right = new BinaryTreeNode<>(8);


        //BinaryTreeUtils.printLevelOrder(root);
        printNodesWithKLeaves(root, 3);
    }

}
