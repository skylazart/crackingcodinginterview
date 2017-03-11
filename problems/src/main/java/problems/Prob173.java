package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

import java.util.LinkedList;

/**
 * Created by fsantos on 3/7/17.
 */
public class Prob173 {
    public static <T extends Comparable<T>> LinkedListNode<T> rotate(LinkedListNode<T> head, int K) {
        if (head == null) return null;
        if (K == 0) return head;

        LinkedListNode<T> fast = head;

        int idx = 0;
        while (fast != null && idx++ < (K - 1)) {
            fast = fast.next;
        }

        if (fast == null)
            throw new IllegalStateException("Linked list len < k");

        LinkedListNode<T> savedNext = fast.next;
        fast.next = null;
        fast = savedNext;
        LinkedListNode<T> newHead = fast;

        while (fast.next != null)
            fast = fast.next;

        fast.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = ListUtils.strToLinkedList("12345");
        ListUtils.printList(head);
        LinkedListNode<Character> newHead = rotate(head, 2);
        ListUtils.printList(newHead);
    }
}
