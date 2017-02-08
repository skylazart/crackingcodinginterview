package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob45 {
    public static <T extends Comparable<T>> void removeNode(LinkedListNode<T> head, LinkedListNode<T> node) {
        if (head == null || node == head) return;
        LinkedListNode<T> current = head;
        while (current.next != node)
            current = current.next;

        current.next = current.next.next;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);
        ListUtils.printList(head);
        removeNode(head, head.next.next);
        ListUtils.printList(head);
    }
}
