package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.DoublyLinkedListNode;

import java.util.Stack;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob105 {
    // In-order
    public static <T extends Comparable<T>>DoublyLinkedListNode<T> bstToDll(BinaryTreeNode<T> root) {
        DoublyLinkedListNode<T> head = null;
        DoublyLinkedListNode<T> dllCurrent = null;

        BinaryTreeNode<T> current = root;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> x = stack.pop();

            // Add to DLL
            if (head == null) {
                head = new DoublyLinkedListNode<>(x.value);
                head.next = head;
                head.prev = head;

                dllCurrent = head;
            } else {
                DoublyLinkedListNode<T> t = new DoublyLinkedListNode<T>(x.value);

                head.prev = t;
                t.next = head;
                t.prev = dllCurrent;

                dllCurrent.next = t;
                dllCurrent = t;
            }

            if (x.right != null) {
                x = x.right;

                while (x != null) {
                    stack.push(x);
                    x = x.left;
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBST();
        DoublyLinkedListNode<Integer> head = bstToDll(root);

    }
}
