package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob102 {
    public static <T extends Comparable<T>> LinkedListNode<T> reverseByN(LinkedListNode<T> head, int N) {
        LinkedListNode<T> prev = null;
        LinkedListNode<T> current = head;

        int count = 0;
        while (current != null && count < N) {
            LinkedListNode<T> savedNext = current.next;
            current.next = prev;
            prev = current;
            current = savedNext;
            count++;
        }

        if (head != null)
            head.next = current;


        count = 0;
        while (count < (N - 1) && current != null) {
            current = current.next;
            count++;
        }

        if (current != null)
            current.next = reverseByN(current.next, N);

        return prev;
    }

    public static <T extends Comparable<T>> LinkedListNode<T> reverse(LinkedListNode<T> head) {
        LinkedListNode<T> prev = null;
        LinkedListNode<T> current = head;

        while (current != null) {
            LinkedListNode<T> savedNext = current.next;
            current.next = prev;
            prev = current;
            current = savedNext;
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = ListUtils.strToLinkedList("123456");
        LinkedListNode<Character> newHead = reverseByN(head, 3);
        ListUtils.printList(newHead);
    }
}
