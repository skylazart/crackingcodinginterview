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

    public static LinkedListNode<Character> strToLinkedList(String s) {
        LinkedListNode<Character> head = new LinkedListNode<>(s.charAt(0));
        LinkedListNode<Character> current = head;

        for (int i = 1; i < s.length(); i++) {
            current.next = new LinkedListNode<>(s.charAt(i));
            current = current.next;
        }

        return head;
    }

    public static LinkedListNode<Integer> arrToLinkedList(Integer[] arr) {
        LinkedListNode<Integer> head = new LinkedListNode<>(arr[0]);
        LinkedListNode<Integer> current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new LinkedListNode<>(arr[i]);
            current = current.next;
        }

        return head;
    }
}
