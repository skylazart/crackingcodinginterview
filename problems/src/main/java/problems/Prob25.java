package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.LinkedListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by fsantos on 12/3/16.
 */
public class Prob25 {
    public static <T extends Comparable<T>> List<LinkedListNode<T>> listOfDepths(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        List<LinkedListNode<T>> list = new ArrayList<>();

        int currentLevel = 0;
        int nextLevel = 0;

        LinkedListNode<T> head = null;
        LinkedListNode<T> tail = null;

        queue.add(root);
        currentLevel = 1;

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.remove();
            currentLevel--;

            System.out.println(node.value);

            if (head == null) {
                head = new LinkedListNode<T>(node.value);
                tail = head;
            } else {
                LinkedListNode<T> t = new LinkedListNode<T>(node.value);
                tail.next = t;
                tail = t;
            }

            if (node.left != null) { nextLevel++; queue.add(node.left); }
            if (node.right != null) { nextLevel++; queue.add(node.right); }

            if (currentLevel == 0) {
                System.out.println("---");
                list.add(head);
                head = tail = null;

                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(5);

        root.right.left = new BinaryTreeNode<>(15);
        root.left.right = new BinaryTreeNode<>(6);

        List<LinkedListNode<Integer>> l = listOfDepths(root);
    }
}
