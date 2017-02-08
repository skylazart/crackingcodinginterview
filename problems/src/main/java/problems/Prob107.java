package problems;

import problems.auxiliar.LinkedListNode;

/**
 * Created by fsantos on 1/25/17.
 */
public class Prob107 {
    public static <T extends Comparable<T>> boolean isCircular(LinkedListNode<T> node) {
        if (node == null || node.next == null) return false;

        LinkedListNode<T> savedNode = node;
        LinkedListNode<T> slow = node.next;
        LinkedListNode<T> fast = node.next.next;

        while (fast != null && fast.next != null) {
            if (fast == savedNode || slow == savedNode) return true;

            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(10);
        head.next = new LinkedListNode<>(20);
        head.next.next = new LinkedListNode<>(30);
        head.next.next.next = new LinkedListNode<>(40);
        head.next.next.next.next = head.next;

        System.out.println(isCircular(head));
    }
}
