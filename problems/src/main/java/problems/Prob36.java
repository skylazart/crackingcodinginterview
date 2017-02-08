package problems;

/**
 * Created by fsantos on 12/12/16.
 */

import problems.auxiliar.BinaryTreeNode;

import java.util.*;

/**
 * Prob36:
 * Find sum of n elements after kth smallest element in BST.
 * Tree is very large, you are not allowed to traverse the tree.
 */
public class Prob36 {
    public static <T extends Comparable<T>> BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T value) {
        if (node == null) return new BinaryTreeNode<T>(value);
        int cmp = value.compareTo(node.value);
        if (cmp > 0)
            node.right = insert(node.right, value);
        else
            node.left = insert(node.left, value);

        return node;
    }

    public static <T extends Comparable<T>> Stack<BinaryTreeNode<T>> goLeft(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> node = root;

        while (node.left != null) {
            stack.add(node);
            node = node.left;
        }

        stack.add(node);
        return stack;
    }

    public static <T extends Comparable<T>> List<BinaryTreeNode<T>> findNSmallest(Stack<BinaryTreeNode<T>> path, int N) {
        List<BinaryTreeNode<T>> list = new ArrayList<>();

        while (!path.isEmpty() && list.size() < N) {
            BinaryTreeNode<T> node = path.pop();
            list.add(node);
            System.out.println(node.value);
        }

        return list;
    }

    public static class FetchNSmallest<T extends Comparable<T>> {
        private final List<BinaryTreeNode<T>> list = new ArrayList<>();
        private final int N;

        public FetchNSmallest(BinaryTreeNode<T> root, int N) {
            this.N = N;
            dfsPostOrder(root);
        }

        private void dfsPostOrder(BinaryTreeNode<T> node) {
            if (node == null) return;
            dfsPostOrder(node.left);
            if (list.size() >= N) return;

            list.add(node);

            dfsPostOrder(node.right);
        }

        private List<BinaryTreeNode<T>> getNSmallest() {
            return list;
        }
    }

    public static <T extends Comparable<T>> void fetchNSmallest(BinaryTreeNode<T> node, int N) {
        if (node == null) return;
        fetchNSmallest(node.left, N);
        System.out.println(node.value + " n: " + N);
        fetchNSmallest(node.right, N - 1);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = null;
        for (int x: Arrays.asList(90, 50, 150, 20, 75, 95, 175, 5, 25, 66, 80, 92, 111, 166, 200)) {
            root = insert(root, x);
        }

        int sum = 0;
        int skip = 2;

        FetchNSmallest<Integer> fetch = new FetchNSmallest<>(root, 5);
        for (BinaryTreeNode<Integer> node: fetch.getNSmallest()) {
            skip--;

            if (skip <= 0) sum += node.value;
        }

        System.out.println(sum);
    }

}
