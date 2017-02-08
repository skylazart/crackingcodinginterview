package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/25/17.
 */
public class Prob110 {
    public static <T extends Comparable<T>>LinkedListNode<T> deleteMafterN(LinkedListNode<T> head, int M, int N) {
        if (head == null) return null;
        LinkedListNode<T> current = head;
        LinkedListNode<T> prev = null;

        int i = 0;

        while (i < N && current != null) {
            prev = current;
            current = current.next;
            i++;
        }

        if (current == null) return head;
        prev.next = deleteM(current, M);
        return head;
    }

    private static <T extends Comparable<T>> LinkedListNode<T> deleteM(LinkedListNode<T> current, int M) {
        while (M > 0 && current != null) {
            M--;
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = ListUtils.strToLinkedList("123456");
        LinkedListNode<Character> newHead = deleteMafterN(head, 3, 2);
        ListUtils.printList(newHead);
    }
}
