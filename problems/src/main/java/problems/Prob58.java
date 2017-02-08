package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

import java.util.Random;

/**
 * Created by fsantos on 1/4/17.
 */
public class Prob58 {
    public static <T extends Comparable<T>> void printRandom(LinkedListNode<T> head) {
        Random rand = new Random();
        int listLen = listLen(head);
        int r = rand.nextInt(listLen);

        LinkedListNode<T> current = head;
        while (current != null) {
            if (r == 0) {
                System.out.println(current.value);
                break;
            }

            r--;
            current = current.next;
        }
    }

    public static <T extends Comparable<T>> int listLen(LinkedListNode<T> head) {
        LinkedListNode<T> current = head;
        int len = 0;

        while (current != null) {
            len++;
            current = current.next;
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        LinkedListNode<Character> list = ListUtils.strToLinkedList(s);
        for (int i = 0; i < s.length(); i++) {
            printRandom(list);
        }
    }
}
