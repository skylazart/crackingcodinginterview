package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob44 {
    /*

    1 2 3 5 6 7

    insert(h, 4)

    prev = 1
    current = 2

    prev = 2
    current = 3

    prev = 3
    current = 5

     */
    public static <T extends Comparable<T>>LinkedListNode<T> insertSorted(LinkedListNode<T> head, T value) {
        if (head == null) return new LinkedListNode<T>(value);
        if (value.compareTo(head.value) < 0) {
            LinkedListNode<T> newHead = new LinkedListNode<T>(value);
            newHead.next = head;
            return newHead;
        }

        LinkedListNode<T> prev = head;
        LinkedListNode<T> current = head.next;

        while (current != null && value.compareTo(current.value) > 0) {
            current = current.next;
            prev = prev.next;
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>(value);
        newNode.next = current;
        prev.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(5);
        head.next.next.next.next = new LinkedListNode<>(6);
        head.next.next.next.next.next = new LinkedListNode<>(7);
        head.next.next.next.next.next.next = new LinkedListNode<>(8);

        LinkedListNode<Integer> newHead = insertSorted(head, 4);
        ListUtils.printList(newHead);
    }
}
