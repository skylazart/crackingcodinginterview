package problems;

import problems.auxiliar.Node;

/**
 * Created by fsantos on 11/29/16.
 */
public class Prob18 {
    public static <T extends Comparable<T>> Node<T> findLoop(Node<T> head) {
        if (head == null) return null;

        Node<T> fast = head.next;
        Node<T> slow = head;

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
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = head.next;

        Node<Integer> loop = findLoop(head);
        if (loop != null)
            System.out.println(loop.value);
    }
}
