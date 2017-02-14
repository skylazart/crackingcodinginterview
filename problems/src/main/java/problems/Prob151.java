package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 2/9/17.
 */
public class Prob151 {
    public static <T extends Comparable<T>> LinkedListNode<T> partition(LinkedListNode<T> head, T key) {
        LinkedListNode<T> headLeft = null;
        LinkedListNode<T> tailLeft = null;

        LinkedListNode<T> headRight = null;
        LinkedListNode<T> tailRight = null;

        LinkedListNode<T> current = head;

        while (current != null) {
            LinkedListNode<T> savedNext = current.next;
            current.next = null;

            if (current.value.compareTo(key) < 0) {
                if (headLeft == null) {
                    headLeft = current;
                    tailLeft = headLeft;
                } else {
                    tailLeft.next = current;
                    tailLeft = tailLeft.next;
                }
            } else {
                if (headRight == null) {
                    headRight = current;
                    tailRight = current;
                } else {
                    tailRight.next = current;
                    tailRight = tailRight.next;
                }
            }

            current = savedNext;
        }

        if (tailLeft != null)
            tailLeft.next = headRight;

        return headLeft;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = ListUtils.strToLinkedList("1432523");
        LinkedListNode<Character> partitioned = partition(head, '3');
        ListUtils.printList(partitioned);
    }
}
