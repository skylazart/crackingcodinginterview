package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob10 {
    private static class Node<T extends  Comparable<T>> {
        private T value;
        private Node<T> next;

        public Node(T v) {
            next = null;
            value = v;
        }
    }

    public static <T extends Comparable<T>> Node<T> removeDups(Node<T> head) {
        if (head == null) return null;

        Set<T> visited = new HashSet<>();
        Node<T> newHead = head;
        Node<T> prev = head;
        Node<T> current = head.next;

        visited.add(head.value);

        while (current != null) {
            if (visited.contains(current.value)) {
                // Skipping
                prev.next = null;
            } else {
                prev.next = current;
                prev = current;
            }

            visited.add(current.value);
            current = current.next;
        }

        return newHead;
    }

    public static <T extends Comparable<T>> void printList (Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            if (current != head) System.out.print(", ");
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(10);
        head.next = new Node<Integer>(10);
        head.next.next = new Node<Integer>(10);

        printList(head);
        Node<Integer> unique = removeDups(head);
        printList(unique);
    }
}
