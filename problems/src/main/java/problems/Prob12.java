package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.LinkedListNode;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob12 {
    public static <T extends Comparable<T>> void removeInTheMiddle(LinkedListNode<T> node) {
        LinkedListNode<T> prev = node;
        LinkedListNode<T> current = node.next;

        while (current.next != null) {
            prev.value = current.value;
            current = current.next;
            prev = prev.next;
        }

        prev.value = current.value;
        prev.next = null;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);

        ListUtils.printList(head);
        removeInTheMiddle(head.next.next);
        ListUtils.printList(head);
    }
}
