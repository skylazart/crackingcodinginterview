package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/25/17.
 */
public class Prob109 {
    public static <T extends Comparable<T>> LinkedListNode<T> mergeInverse(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        LinkedListNode<T> newHead = null;

        if (l1.value.compareTo(l2.value) < 0) {
            newHead = l1;
            l1 = l1.next;
        } else {
            newHead = l2;
            l2 = l2.next;
        }

        newHead.next = null;

        while (l1 != null && l2 != null) {
            if (l1.value.compareTo(l2.value) < 0) {
                LinkedListNode<T> savedNext = l1.next;
                l1.next = newHead;
                newHead = l1;
                l1 = savedNext;
            } else {
                LinkedListNode<T> savedNext = l2.next;
                l2.next = newHead;
                newHead = l2;
                l2 = savedNext;
            }
        }

        while (l1 != null) {
            LinkedListNode<T> savedNext = l1.next;
            l1.next = newHead;
            newHead = l1;
            l1 = savedNext;
        }

        while (l2 != null) {
            LinkedListNode<T> savedNext = l2.next;
            l2.next = newHead;
            newHead = l2;
            l2 = savedNext;
        }

        return newHead;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head1 = ListUtils.strToLinkedList("135");
        LinkedListNode<Character> head2 = ListUtils.strToLinkedList("2467");
        LinkedListNode<Character> headMerged = mergeInverse(head1, head2);
        ListUtils.printList(headMerged);
    }
}
