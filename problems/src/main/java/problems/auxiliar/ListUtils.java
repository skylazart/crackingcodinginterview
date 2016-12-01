package problems.auxiliar;

/**
 * Created by fsantos on 11/25/16.
 */
public final class ListUtils {
    public static <T extends Comparable<T>> void printList(LinkedListNode<T> head) {
        LinkedListNode<T> current = head;

        while (current != null) {
            if (current != head) System.out.print(" -> ");
            System.out.print(current.value);

            current = current.next;
        }

        System.out.println();
    }
}
