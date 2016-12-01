package problems;

import problems.auxiliar.LinkedListNode;

/**
 * Created by fsantos on 11/29/16.
 */
public class Prob18 {
    public static <T extends Comparable<T>> LinkedListNode<T> findLoop(LinkedListNode<T> head) {
        if (head == null) return null;

        LinkedListNode<T> fast = head.next;
        LinkedListNode<T> slow = head;

        while (fast.next != null) {
            if (fast == slow) {
                // Loop found
                return slow;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        // Loop not found
        return null;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);
        head.next.next.next.next.next = head.next;

        LinkedListNode<Integer> loop = findLoop(head);
        if (loop != null)
            System.out.println(loop.value);
    }
}
