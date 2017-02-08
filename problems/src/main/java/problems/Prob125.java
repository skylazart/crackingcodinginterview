package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

import java.util.*;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob125 {
    public static <T extends Comparable<T>> BinaryTreeNode<T> convertBinaryTreeToDoublyLinkedList(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> head = null;
        BinaryTreeNode<T> tail = null;

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();
            BinaryTreeNode<T> nodeRight = node.right;

            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.right = node;
                node.right = tail;
                tail = node;
            }

            if (nodeRight != null) {
                node = nodeRight;

                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTreeFromList(new Integer[] {1, 2, 3, 4});
        BinaryTreeNode<Integer> head = convertBinaryTreeToDoublyLinkedList(root);

        BinaryTreeNode<Integer> current = head;
        for (int i = 0; i < 10; i++) {
            System.out.println(current.value);
            current = current.right;
        }

    }
}
