package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.LinkedListNode;

import java.util.Stack;

/**
 * Created by fsantos on 11/28/16.
 */
public class Prob16 {
    public static <T extends Comparable<T>> boolean isPalindromeUsingStack(LinkedListNode<T> head) {
        Stack<LinkedListNode<T>> stack = fillStack(head);
        LinkedListNode<T> current = head;

        while (current != null) {
            LinkedListNode<T> n = stack.pop();
            if (n.value.compareTo(current.value) != 0) {
                emptyStack(stack);
                return false;
            }

            current = current.next;
        }
        return true;
    }

    private static <T extends Comparable<T>> void emptyStack(Stack<LinkedListNode<T>> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    private static <T extends Comparable<T>> Stack<LinkedListNode<T>> fillStack(LinkedListNode<T> head) {
        Stack<LinkedListNode<T>> stack = new Stack<>();
        LinkedListNode<T> current = head;

        while (current != null) {
            stack.add(current);
            current = current.next;
        }

        return stack;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = new LinkedListNode<>('a');
        head.next = new LinkedListNode<>('b');
        head.next.next = new LinkedListNode<>('c');
        head.next.next.next = new LinkedListNode<>('d');

        ListUtils.printList(head);
        System.out.println(isPalindromeUsingStack(head));
    }
}
