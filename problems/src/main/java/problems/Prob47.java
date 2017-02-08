package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.LinkedListNode;

import java.util.Stack;

import static problems.auxiliar.ListUtils.printList;
import static problems.auxiliar.ListUtils.strToLinkedList;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob47 {
    //TODO
    public static <T extends Comparable<T>> LinkedListNode<T> reverse(LinkedListNode<T> head, int K) {
        return null;
    }

    public static void main(String[] args) {
        LinkedListNode<Character> head = strToLinkedList("123456789");
        printList(head);
        LinkedListNode<Character> reversedHead = reverse(head, 3);
        printList(reversedHead);
    }
}
