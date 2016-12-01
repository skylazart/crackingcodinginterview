package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.LinkedListNode;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob13 {
    private static class MyCustomList<T extends Comparable<T>> {
        private LinkedListNode<T> head;
        private LinkedListNode<T> tail;

        MyCustomList() {
            head = null;
            tail = null;
        }

        public void append(LinkedListNode<T> n) {
            if (head == null) {
                head = tail = n;
                return;
            }

            tail.next = n;
            tail = tail.next;
        }
    }

    public static <T extends Comparable<T>> LinkedListNode<T> partition(LinkedListNode<T> head, T patitionValue) {
        MyCustomList<T> greaterThan = new MyCustomList<T>();
        MyCustomList<T> lessThan = new MyCustomList<T>();

        LinkedListNode<T> current = head;
        while (current != null) {
            if (current.value.compareTo(patitionValue) < 0)
                lessThan.append(current);
            else
                greaterThan.append(current);

            current = current.next;
        }

        return sumCustomList(lessThan, greaterThan);
    }

    private static <T extends Comparable<T>> LinkedListNode<T> sumCustomList(MyCustomList<T> lessThan, MyCustomList<T> greaterThan) {
        LinkedListNode<T> head = lessThan.head;
        lessThan.tail.next = greaterThan.head;
        greaterThan.tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(4);
        head.next = new LinkedListNode<>(6);
        head.next.next = new LinkedListNode<>(9);
        head.next.next.next = new LinkedListNode<>(1);
        head.next.next.next.next = new LinkedListNode<>(1);
        head.next.next.next.next.next = new LinkedListNode<>(1);

        LinkedListNode<Integer> l = partition(head, 4);
        ListUtils.printList(l);
    }
}
