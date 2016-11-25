package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.Node;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob12 {
    public static <T extends Comparable<T>> void removeInTheMiddle(Node<T> node) {
        Node<T> prev = node;
        Node<T> current = node.next;

        while (current.next != null) {
            prev.value = current.value;
            current = current.next;
            prev = prev.next;
        }

        prev.value = current.value;
        prev.next = null;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        ListUtils.printList(head);
        removeInTheMiddle(head.next.next);
        ListUtils.printList(head);
    }
}
