package problems;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob11 {
    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> next;

        public Node(T v) {
            next = null;
            value = v;
        }
    }

    public static <T extends Comparable<T>> Node<T> findKthToEnd(Node<T> head, int k) {
        if (head == null) return null;

        Node<T> fast = head;
        Node<T> slow;

        for (int i = 0; i < k & fast != null; i++) {
            fast = fast.next;
        }

        slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(10);
        head.next = new Node<>(20);
        head.next.next = new Node<>(30);

        Node<Integer> kth = findKthToEnd(head, 2);
        System.out.println(kth.value);
    }
}
