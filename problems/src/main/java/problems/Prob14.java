package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.Node;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob14 {
    private static class CustomList {
        private Node<Integer> head = null;
        private Node<Integer> tail = null;

        void append(Integer x) {
            if (head == null) {
                head = new Node<>(x);
                tail = head;
            } else {
                tail.next = new Node<>(x);
                tail = tail.next;
            }
        }
    }

    public static Node<Integer> sumLinkedListValues(Node<Integer> l1, Node<Integer> l2) {
        CustomList result = new CustomList();
        Node<Integer> curL1 = l1;
        Node<Integer> curL2 = l2;

        int carry = 0;

        while (curL1 != null && curL2 != null) {
            int a = curL1.value;
            int b = curL2.value;

            int sum = a + b + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            result.append(sum);

            curL1 = curL1.next;
            curL2 = curL2.next;
        }

        while (curL1 != null) {
            int a = curL1.value;
            int sum = a + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 9;
            } else {
                carry = 0;
            }

            result.append(sum);
            curL1 = curL1.next;
        }

        while (curL2 != null) {
            int b = curL2.value;

            int sum = b + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 9;
            } else {
                carry = 0;
            }

            result.append(sum);
            curL2 = curL2.next;
        }

        return result.head;
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(7);
        a.next = new Node<>(1);
        a.next.next = new Node<>(6);

        Node<Integer> b = new Node<>(5);
        b.next = new Node<>(9);
        b.next.next = new Node<>(2);

        Node<Integer> sum = sumLinkedListValues(a, b);
        ListUtils.printList(sum);
    }
}
