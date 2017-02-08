package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob50 {
    /*
    1 3 5 7
    2 4 6 8
     */
    public static <T extends Comparable<T>> LinkedListNode<T> mergeAlternatedFashion(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        LinkedListNode<T> head = l1;

        while (l1 != null && l2 != null) {
            LinkedListNode<T> nextL1 = l1.next;
            LinkedListNode<T> nextL2 = l2.next;

            l1.next = l2;
            l2.next = nextL1;
            l1 = nextL1;
            l2 = nextL2;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> l1 = ListUtils.strToLinkedList("1357");
        LinkedListNode<Character> l2 = ListUtils.strToLinkedList("2468");
        LinkedListNode<Character> merged = mergeAlternatedFashion(l1, l2);
        ListUtils.printList(merged);
    }
}
