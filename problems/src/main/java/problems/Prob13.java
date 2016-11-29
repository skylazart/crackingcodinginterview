package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.Node;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob13 {
    private static class MyCustomList<T extends Comparable<T>> {
        private Node<T> head;
        private Node<T> tail;

        MyCustomList() {
            head = null;
            tail = null;
        }

        public void append(Node<T> n) {
            if (head == null) {
                head = tail = n;
                return;
            }

            tail.next = n;
            tail = tail.next;
        }
    }

    public static <T extends Comparable<T>> Node<T> partition(Node<T> head, T patitionValue) {
        MyCustomList<T> greaterThan = new MyCustomList<T>();
        MyCustomList<T> lessThan = new MyCustomList<T>();

        Node<T> current = head;
        while (current != null) {
            if (current.value.compareTo(patitionValue) < 0)
                lessThan.append(current);
            else
                greaterThan.append(current);

            current = current.next;
        }

        return sumCustomList(lessThan, greaterThan);
    }

    private static <T extends Comparable<T>> Node<T> sumCustomList(MyCustomList<T> lessThan, MyCustomList<T> greaterThan) {
        Node<T> head = lessThan.head;
        lessThan.tail.next = greaterThan.head;
        greaterThan.tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(4);
        head.next = new Node<>(6);
        head.next.next = new Node<>(9);
        head.next.next.next = new Node<>(1);
        head.next.next.next.next = new Node<>(1);
        head.next.next.next.next.next = new Node<>(1);

        Node<Integer> l = partition(head, 4);
        ListUtils.printList(l);
    }
}
