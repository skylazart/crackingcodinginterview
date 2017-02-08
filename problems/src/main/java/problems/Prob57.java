package problems;

import java.util.Stack;

/**
 * Created by fsantos on 1/4/17.
 */
public class Prob57 {
    public static class Node <T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static <T extends Comparable<T>> void calculatePathLengthFromRoot(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        path(root, 1, stack);
    }

    private static <T extends Comparable<T>> void path(Node<T> node, int len, Stack<Node<T>> stack) {
        if (node == null) return;
        if (node.right == null && node.left == null) {
            if (len < 4) {
                // Remove it
                Node<T> parent = stack.peek();
                if (parent.left == node) parent.left = null;
                else parent.right = null;
            }
        }

        stack.push(node);
        path(node.left, len + 1, stack);
        path(node.right, len + 1, stack);
        stack.pop();
    }

    private static <T extends Comparable<T>> void printStack(Stack<Node<T>> stack) {
        for (Node<T> x: stack) {
            System.out.println("stack: " + x.value);
        }
        System.out.println();

        if (stack.size() > 0) {
            Node<T> p = stack.peek();
            System.out.println("TOP: " + p.value);
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(3);
        root.left.left = new Node<>(6);
        root.left.left.right = new Node<>(8);
        root.right = new Node<>(2);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(4);
        root.right.right.right = new Node<>(7);

        calculatePathLengthFromRoot(root);
    }
}
