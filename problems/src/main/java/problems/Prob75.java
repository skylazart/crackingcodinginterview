package problems;

import problems.auxiliar.BinaryTreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by fsantos on 1/9/17.
 */
public class Prob75 {
    public static <T extends Comparable<T>> void dfsInteractive(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> node = root;

        // Going left
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        // Returning from left
        while (!stack.isEmpty()) {
            node = stack.pop();

            System.out.println(node.value);

            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    private static <T extends Comparable<T>> void printStack(Stack<BinaryTreeNode<T>> stack) {
        System.out.println("Stack dump");
    }

    public static <T extends Comparable<T>> void dfsRecursive(BinaryTreeNode<T> node) {
        if (node == null) return;
        dfsRecursive(node.left);
        System.out.println(node.value);
        dfsRecursive(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Character> root = new BinaryTreeNode<>('a');
        root.left = new BinaryTreeNode<>('b');
        root.left.left = new BinaryTreeNode<>('c');
        root.left.left.left = new BinaryTreeNode<>('d');
        root.left.left.right = new BinaryTreeNode<>('e');
        root.left.right = new BinaryTreeNode<>('i');
        root.right = new BinaryTreeNode<>('f');
        root.right.right = new BinaryTreeNode<>('g');
        root.right.left = new BinaryTreeNode<>('h');

        dfsInteractive(root);
        System.out.println("--//--");
        dfsRecursive(root);
    }
}
