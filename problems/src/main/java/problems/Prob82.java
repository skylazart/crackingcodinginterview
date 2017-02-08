package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by fsantos on 1/13/17.
 */
public class Prob82 {
    /*
    from  1->2->3->4->5
    to    1->5->2->4->3
     */
    public static LinkedListNode<Integer> modifiedReverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> savedNext = null;
        boolean fromLast = true;

        while (curr != null) {
            if (!fromLast) {
                LinkedListNode<Integer> t = savedNext.next;
                curr.next = savedNext;
                savedNext = t;
            }

            if (fromLast) {
                savedNext = curr.next;
                curr.next = removeLast(curr);
            }

            curr = curr.next;
            fromLast = !fromLast;
        }

        return head;
    }

    public static LinkedListNode<Integer> removeLast(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        LinkedListNode<Integer> last = fast;
        slow.next = null;
        return last;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = ListUtils.arrToLinkedList(new Integer[]{1, 2, 3, 4, 5});
        LinkedListNode<Integer> reversed = modifiedReverse(head);
        ListUtils.printList(reversed);
    }
}
