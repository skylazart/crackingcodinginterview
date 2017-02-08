package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/25/17.
 */
public class Prob108 {

    public static <T extends Comparable<T>>LinkedListNode<T> zigZag(LinkedListNode<T> head) {
        LinkedListNode<T> newHead = head;
        LinkedListNode<T> current = newHead;

        head = head.next;
        newHead.next = null;

        while (head != null) {
            current.next = removeTail(head);
            if (current.next == null) break;
            current = current.next;

            current.next = head;
            head = head.next;
            current.next.next = null;

            current = current.next;
        }

        return newHead;
    }

    private static <T extends Comparable<T>> LinkedListNode<T> removeTail(LinkedListNode<T> head) {
        LinkedListNode<T> prev = null;
        LinkedListNode<T> current = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        LinkedListNode<T> saved = prev.next;
        prev.next = null;
        return saved;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = ListUtils.strToLinkedList("1234567");
        ListUtils.printList(head);
        LinkedListNode<Character> newHead = zigZag(head);
        ListUtils.printList(newHead);
    }
}
