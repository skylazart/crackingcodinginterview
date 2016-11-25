package problems.auxiliar;

/**
 * Created by fsantos on 11/25/16.
 */
public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> next;

    public Node(T v) {
        value = v;
        next = null;
    }
}
