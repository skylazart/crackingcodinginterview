package problems.auxiliar;

/**
 * Created by fsantos on 11/25/16.
 */
public class LinkedListNode<T extends Comparable<T>> {
    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T v) {
        value = v;
        next = null;
    }
}
