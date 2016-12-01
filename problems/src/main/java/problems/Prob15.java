package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.LinkedListNode;

import java.util.Stack;

/**
 * Created by fsantos on 11/28/16.
 */
public class Prob15 {

    private static class ResultLinkedList {
        private LinkedListNode<Integer> head;

        public ResultLinkedList() {
            head = null;
        }

        public void append(Integer x) {
            if (head == null) {
                head = new LinkedListNode<>(x);
            } else {
                LinkedListNode<Integer> tmp = new LinkedListNode<>(x);
                tmp.next = head;
                head = tmp;
            }
        }

    }

    public static LinkedListNode<Integer> sumLinkedList(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        Stack<Integer> stackL1 = loadIntoStack(l1);
        Stack<Integer> stackL2 = loadIntoStack(l2);

        ResultLinkedList result = new ResultLinkedList();

        int carry = 0;

        while (!stackL1.isEmpty() && !stackL2.isEmpty()) {
            Integer a = stackL1.pop();
            Integer b = stackL2.pop();

            Integer sum = a + b + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum -= carry * 10;
            }

            result.append(sum);
        }

        sumLeftDigits(result, carry, stackL1);
        sumLeftDigits(result, carry, stackL2);

        return result.head;
    }

    private static void sumLeftDigits(ResultLinkedList result, int carry, Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            Integer x = stack.pop();
            Integer sum = x + carry;

            if (sum > 9) {
                carry = sum / 10;
                sum -= carry * 10;
            }

            result.append(sum);
        }
    }

    private static Stack<Integer> loadIntoStack(LinkedListNode<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        LinkedListNode<Integer> current = list;
        while (current != null) {
            stack.add(current.value);
            current = current.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> a = new LinkedListNode<>(6);
        a.next = new LinkedListNode<>(1);
        a.next.next = new LinkedListNode<>(7);

        LinkedListNode<Integer> b = new LinkedListNode<>(2);
        b.next = new LinkedListNode<>(9);
        b.next.next = new LinkedListNode<>(5);

        LinkedListNode<Integer> sum = sumLinkedList(a, b);
        ListUtils.printList(sum);
    }
}