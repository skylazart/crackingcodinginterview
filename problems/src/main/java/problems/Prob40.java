package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 12/10/16.
 */

/**
 * Given a singly linked list: 1->2->3->4->5
 * Change it to 1->5->2->4->3 using O(1) space
 */

/*

1 -> 2 -> 3 -> 4 -> 5

fast = 1
slow = 1
savedHead = 1

fast = 3
slow = 2

fast = 5
slow = 3

1 -> 2 -> 3 -> 4 -> 5
// Inverting
prev = null
fast = 5
slow = 3

loop while slow.next != null
t = 4
3 -> null
prev = 3
slow = 4

t = 5
null <- 3 <- 4
prev = 4
slow = 5

null <- 3 <- 4 <- 5


// Merging
currentFw = 1
currentBw = 5
savedSlow = 3

loop:
    savedCurrentFw = 2
    savedCurrentBw = 4

    1 -> 5

    currentFw = 2
    currentBw = 4

    savedCurrentFw = 3
    savedCurrentBw = 3

    2 ->
 */
public class Prob40 {
    public static <T extends Comparable<T>> LinkedListNode<T> modReverse(LinkedListNode<T> head) {
        LinkedListNode<T> fast = head;
        LinkedListNode<T> slow = head;

        LinkedListNode<T> savedHead = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        LinkedListNode<T> savedSlow = slow;

        // Inverting
        LinkedListNode<T> prev = null;
        while (slow.next != null) {
            LinkedListNode<T> t = slow.next;
            slow.next = prev;
            prev = slow;
            slow = t;
        }

        slow.next = prev;

        // Merging the half of original list with the half of inverted list

        LinkedListNode<T> currentForward = savedHead;
        LinkedListNode<T> currentBackward = slow;
        while (currentForward != savedSlow) {
            LinkedListNode<T> savedCurrentForward = currentForward.next;
            LinkedListNode<T> savedCurrentBackward = currentBackward.next;

            currentForward.next = currentBackward;
            currentBackward.next = savedCurrentForward;

            currentForward = savedCurrentForward;
            currentBackward = savedCurrentBackward;
        }

        return savedHead;
    }


    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);

        ListUtils.printList(head);
        LinkedListNode<Integer> modReverse = modReverse(head);
        ListUtils.printList(modReverse);
    }
}
