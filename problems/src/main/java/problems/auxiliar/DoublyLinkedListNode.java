package problems.auxiliar;

/**
 * Created by fsantos on 12/1/16.
 */
public class DoublyLinkedListNode<T extends Comparable<T>> {
    private final T value;
    private DoublyLinkedListNode<T> prev;
    private DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T value) {
        this.value = value;
        prev = null;
        next = null;
    }

    public T getValue() {
        return value;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }
}
