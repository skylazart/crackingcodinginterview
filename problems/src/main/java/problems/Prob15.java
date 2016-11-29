package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.Node;

import java.util.Stack;

/**
 * Created by fsantos on 11/28/16.
 */
public class Prob15 {

    private static class ResultLinkedList {
        private Node<Integer> head;

        public ResultLinkedList() {
            head = null;
        }

        public void append(Integer x) {
            if (head == null) {
                head = new Node<>(x);
            } else {
                Node<Integer> tmp = new Node<>(x);
                tmp.next = head;
                head = tmp;
            }
        }

    }

    public static Node<Integer> sumLinkedList(Node<Integer> l1, Node<Integer> l2) {
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

    private static Stack<Integer> loadIntoStack(Node<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        Node<Integer> current = list;
        while (current != null) {
            stack.add(current.value);
            current = current.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(6);
        a.next = new Node<>(1);
        a.next.next = new Node<>(7);

        Node<Integer> b = new Node<>(2);
        b.next = new Node<>(9);
        b.next.next = new Node<>(5);

        Node<Integer> sum = sumLinkedList(a, b);
        ListUtils.printList(sum);
    }
}