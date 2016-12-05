package problems;

/**
 * Created by fsantos on 12/5/16.
 */

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Merge two sorted linked lists
 */

public class Prob29 {
    public static <T extends Comparable<T>> LinkedListNode<T> mergeLinkedList(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        LinkedListNode<T> head = null;
        LinkedListNode<T> tail = null;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Preparing new head
        if (l1.value.compareTo(l2.value) < 0) {
            head = l1;
            tail = head;
            l1 = l1.next;
        } else {
            head = l2;
            tail = head;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.value.compareTo(l2.value) < 0) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // Filling in the missing values in l1 and l2
        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        // Returning new head
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> l1 = new LinkedListNode<>(1);
        l1.next = new LinkedListNode<>(10);

        LinkedListNode<Integer> l2 = new LinkedListNode<>(2);
        l2.next = new LinkedListNode<>(3);
        l2.next.next = new LinkedListNode<>(11);

        LinkedListNode<Integer> merged = mergeLinkedList(l1, l2);
        ListUtils.printList(merged);
    }
}
