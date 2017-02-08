package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

import java.util.*;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob126 {
    public static <T extends Comparable<T>> void printCousins(BinaryTreeNode<T> root, T wanted) {
        boolean print = false;
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();

        queue.add(root);
        int totalCurrentLevel = 1;
        int totalNextLevel = 0;

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.remove();
            totalCurrentLevel--;

            if (print) System.out.print(node.value + " ");

            if (node.value.compareTo(wanted) == 0) print = true;

            if (node.left != null) {
                queue.add(node.left);
                totalNextLevel++;
            }

            if (node.right != null) {
                queue.add(node.right);
                totalNextLevel++;
            }

            if (totalCurrentLevel == 0) {
                print = false;
                totalCurrentLevel = totalNextLevel;
                totalNextLevel = 0;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBST();
        BinaryTreeUtils.printLevelOrder(root);
        printCousins(root, 9);
    }
}
