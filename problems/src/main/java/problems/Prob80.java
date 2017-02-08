package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

import java.util.Stack;

/**
 * Created by fsantos on 1/12/17.
 */
public class Prob80 {
    /*
    1 2 3 3 2 1

    fast = 1
    slow = 1

    slow = 2
    fast = 3

    slow = 3
    fast = 2

    1 2 3 4 3 2 1

    fast = 1
    slow = 1

    fast = 3
    slow = 2

    fast = 3
    slow = 3

    fast = 1
    slow = 4
    */

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        Stack<LinkedListNode<Integer>> stack = new Stack<>();

        boolean skiped = false;

        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            LinkedListNode<Integer> tmp = stack.peek();
            if (!tmp.value.equals(slow.value)) {
                if (!skiped) {
                    skiped = true;
                    slow = slow.next;
                    continue;
                }
                return false;
            }

            stack.pop();
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = ListUtils.arrToLinkedList(new Integer[] {1, 2, 3, 3, 2, 1});
        System.out.println(isPalindrome(head));

        LinkedListNode<Integer> head1 = ListUtils.arrToLinkedList(new Integer[] {1, 2, 3, 4, 3, 2, 1});
        System.out.println(isPalindrome(head1));

    }
}
