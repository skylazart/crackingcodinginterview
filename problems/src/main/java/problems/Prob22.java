package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.DoublyLinkedListNode;

/**
 * Created by fsantos on 12/1/16.
 */
public class Prob22 {

    public class DLL <T extends Comparable<T>> {
        private DoublyLinkedListNode<T> first;
        private DoublyLinkedListNode<T> last;

        public DLL() {
            first = null;
            last = null;
        }

        public void add(T value) {
            if (first == null) {
                first = new DoublyLinkedListNode<T>(value);
                last = first;
                last.next = first;
                last.prev = first;
                first.next = last;
            } else {
                DoublyLinkedListNode<T> t = new DoublyLinkedListNode<T>(value);
                t.next = first;
                t.prev = last;
                last.next = t;
                last = t;
                first.prev = last;
            }
        }

        public DoublyLinkedListNode<T> getFirst() {
            return first;
        }
    }

    public <T extends Comparable<T>> DoublyLinkedListNode<T> makeDLL(BinaryTreeNode<T> root) {
        DLL<T> dll = new DLL<T>();
        makeDLL(root, dll);
        return dll.first;
    }

    private <T extends Comparable<T>> void makeDLL(BinaryTreeNode<T> node, DLL<T> dll) {
        if (node == null) return;
        makeDLL(node.left, dll);
        dll.add(node.value);
        makeDLL(node.right, dll);
    }

    private void run() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(4);

        DoublyLinkedListNode<Integer> first = makeDLL(root);
    }

    public static void main(String[] args) {
        new Prob22().run();
    }
}
