package problems;

import problems.auxiliar.ListUtils;
import problems.auxiliar.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 11/29/16.
 */
public class Prob17 {
    public static <T extends Comparable<T>> LinkedListNode<T> findIntersection(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        Set<LinkedListNode<T>> set = fillSet(l1);
        LinkedListNode<T> l2Inter = l2;

        while (l2Inter != null) {
            if (set.contains(l2Inter))
                return l2Inter;

            l2Inter = l2Inter.next;
        }

        // Not found
        return null;
    }

    private static <T extends Comparable<T>> Set<LinkedListNode<T>> fillSet(LinkedListNode<T> head) {
        Set<LinkedListNode<T>> set = new HashSet<>();
        LinkedListNode<T> inter = head;

        while (inter != null) {
            set.add(inter);
            inter = inter.next;
        }

        return set;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> l1 = new LinkedListNode<>(1);
        l1.next = new LinkedListNode<>(2);
        l1.next.next = new LinkedListNode<>(3);
        l1.next.next.next = new LinkedListNode<>(4);
        l1.next.next.next.next = new LinkedListNode<>(5);
        l1.next.next.next.next.next = new LinkedListNode<>(6);

        LinkedListNode<Integer> l2 = l1.next.next.next.next.next;
        l2.next = new LinkedListNode<>(7);

        ListUtils.printList(l1);
        ListUtils.printList(l2);

        LinkedListNode<Integer> intersection = findIntersection(l1, l2);
        if (intersection != null)
            System.out.println(intersection.value);
    }
}
