package problems.auxiliar;

/**
 * Created by fsantos on 12/1/16.
 */
public class DoublyLinkedListNode<T extends Comparable<T>> {
    public final T value;
    public DoublyLinkedListNode<T> prev;
    public DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T value) {
        this.value = value;
        prev = null;
        next = null;
    }

    public T getValue() {
        return value;
    }
}
