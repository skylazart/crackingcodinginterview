package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.Node;

import java.util.Stack;

/**
 * Created by fsantos on 11/28/16.
 */
public class Prob16 {
    public static <T extends Comparable<T>> boolean isPalindromeUsingStack(Node<T> head) {
        Stack<Node<T>> stack = fillStack(head);
        Node<T> current = head;

        while (current != null) {
            Node<T> n = stack.pop();
            if (n.value.compareTo(current.value) != 0) {
                emptyStack(stack);
                return false;
            }

            current = current.next;
        }
        return true;
    }

    private static <T extends Comparable<T>> void emptyStack(Stack<Node<T>> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    private static <T extends Comparable<T>> Stack<Node<T>> fillStack(Node<T> head) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = head;

        while (current != null) {
            stack.add(current);
            current = current.next;
        }

        return stack;
    }

    public static void main(String[] args) {
        Node<Character> head = new Node<>('a');
        head.next = new Node<>('b');
        head.next.next = new Node<>('c');
        head.next.next.next = new Node<>('d');

        ListUtils.printList(head);
        System.out.println(isPalindromeUsingStack(head));
    }
}
