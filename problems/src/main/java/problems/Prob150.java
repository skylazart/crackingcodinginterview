package problems;

import problems.auxiliar.LinkedListNode;

/**
 * Created by fsantos on 2/9/17.
 */
public class Prob150 {
    public static <T extends Comparable<T>> boolean findSubList(LinkedListNode<T> list, LinkedListNode<T> subList) {
        if (list == null || subList == null) return false;
        LinkedListNode<T> current = list;

        while (current != null) {
            if (current.value.compareTo(subList.value) == 0)
                if (compare(current, subList))
                    return true;

            current = current.next;
        }

        return false;
    }

    private static <T extends Comparable<T>> boolean compare(LinkedListNode<T> l1, LinkedListNode<T> l2) {
        while (l1 != null && l2 != null) {
            if (l1.value.compareTo(l2.value) != 0) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        // Both should be null to be equal
        return l1 == l2;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head1 = new LinkedListNode<>(5);
        head1.next = new LinkedListNode<>(10);
        head1.next.next = new LinkedListNode<>(20);

        LinkedListNode<Integer> head2 = new LinkedListNode<>(10);
        head2.next = new LinkedListNode<>(20);

        System.out.println(findSubList(head1, head2));
    }
}
