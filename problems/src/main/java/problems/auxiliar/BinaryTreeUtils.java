package problems.auxiliar;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by fsantos on 1/4/17.
 */
public class BinaryTreeUtils {
    public static <T extends Comparable<T>> void printInOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public static <T extends Comparable<T>> void printLevelOrder(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);

        int currentLevel = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.remove();
            currentLevel--;

            System.out.print(node.value + " ");

            if (node.left != null) {
                nextLevel++;
                queue.add(node.left);
            }

            if (node.right != null) {
                nextLevel++;
                queue.add(node.right);
            }

            if (currentLevel == 0) {
                System.out.println();

                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }

        System.out.println("--//--");
    }
}
