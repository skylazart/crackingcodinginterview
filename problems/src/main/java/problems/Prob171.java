package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by fsantos on 2/19/17.
 */
public class Prob171 {
    public static <T extends Comparable<T>> BinaryTreeNode<T> binarySearchTreeToLinkedListInPlace(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> head = null;
        BinaryTreeNode<T> tail = null;

        while (current != null) {
            stack.push(current);
            current = current.left;
        }


        while (!stack.isEmpty()) {
            BinaryTreeNode<T> x = stack.pop();
            queue.add(x);

            if (x.right != null) {
                x = x.right;
                while (x != null) {
                    stack.push(x);
                    x = x.left;
                }
            }
        }

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> x = queue.remove();
            if (head == null) {
                head = tail = x;
                x.right = null;
            } else {
                x.right = null;
                tail.right = x;
                tail = x;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBST();
        BinaryTreeNode<Integer> head = binarySearchTreeToLinkedListInPlace(root);

        BinaryTreeNode<Integer> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.right;
        }
    }
}
