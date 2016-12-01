package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.LinkedListNode;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob14 {
    private static class CustomList {
        private LinkedListNode<Integer> head = null;
        private LinkedListNode<Integer> tail = null;

        void append(Integer x) {
            if (head == null) {
                head = new LinkedListNode<>(x);
                tail = head;
            } else {
                tail.next = new LinkedListNode<>(x);
                tail = tail.next;
            }
        }
    }

    public static LinkedListNode<Integer> sumLinkedListValues(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        CustomList result = new CustomList();
        LinkedListNode<Integer> curL1 = l1;
        LinkedListNode<Integer> curL2 = l2;

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
        LinkedListNode<Integer> a = new LinkedListNode<>(7);
        a.next = new LinkedListNode<>(1);
        a.next.next = new LinkedListNode<>(6);

        LinkedListNode<Integer> b = new LinkedListNode<>(5);
        b.next = new LinkedListNode<>(9);
        b.next.next = new LinkedListNode<>(2);

        LinkedListNode<Integer> sum = sumLinkedListValues(a, b);
        ListUtils.printList(sum);
    }
}
