package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 11/29/16.
 */
public class Prob17 {
    public static <T extends Comparable<T>> Node<T> findIntersection(Node<T> l1, Node<T> l2) {
        Set<Node<T>> set = fillSet(l1);
        Node<T> l2Inter = l2;

        while (l2Inter != null) {
            if (set.contains(l2Inter))
                return l2Inter;

            l2Inter = l2Inter.next;
        }

        // Not found
        return null;
    }

    private static <T extends Comparable<T>> Set<Node<T>> fillSet(Node<T> head) {
        Set<Node<T>> set = new HashSet<>();
        Node<T> inter = head;

        while (inter != null) {
            set.add(inter);
            inter = inter.next;
        }

        return set;
    }

    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(1);
        l1.next = new Node<>(2);
        l1.next.next = new Node<>(3);
        l1.next.next.next = new Node<>(4);
        l1.next.next.next.next = new Node<>(5);
        l1.next.next.next.next.next = new Node<>(6);

        Node<Integer> l2 = l1.next.next.next.next.next;
        l2.next = new Node<>(7);

        ListUtils.printList(l1);
        ListUtils.printList(l2);

        Node<Integer> intersection = findIntersection(l1, l2);
        if (intersection != null)
            System.out.println(intersection.value);
    }
}
