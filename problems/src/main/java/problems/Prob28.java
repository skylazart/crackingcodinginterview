package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 12/5/16.
 */

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */

/*

tree:
      10
20          30
         5       4
       2   1   9   10

subtree:
      30
  5       4
2   1   9   10


dfsInteractive(10) | dfsInteractive(30)

dfsInteractive(10, 30)

dfsInteractive(20, 30)
    false

dfsInteractive(30, 30)
    true

 */

public class Prob28 {
    public static <T extends Comparable<T>> boolean isSubTree(BinaryTreeNode<T> tree, BinaryTreeNode<T> subTree) {
        if (subTree == null) {
            // Sanity check
            return false;
        }

        return dfs(tree, subTree);
    }

    public static <T extends Comparable<T>> boolean dfs(BinaryTreeNode<T> node, BinaryTreeNode<T> subNode) {
        if (node == null) {
            return false;
        }

        if (node.value.compareTo(subNode.value) == 0)
            return compare(node, subNode);

        return dfs(node.right, subNode) || dfs(node.left, subNode);
    }

    public static <T extends Comparable<T>> boolean compare(BinaryTreeNode<T> node, BinaryTreeNode<T> subNode) {
        if (node == null && subNode == null) return true;

        if (node.value.compareTo(subNode.value) != 0)
            return false;

        return compare(node.left, subNode.left) && compare(node.right, subNode.right);
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        int res = value.compareTo(node.value);
        if (res == 0) {
            // Found
            return node;
        }

        if (res > 0) return findNode(node.right, value);
        return findNode(node.left, value);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(10);
        tree.right = new BinaryTreeNode<>(30);
        tree.right.right = new BinaryTreeNode<>(4);
        tree.right.right.right = new BinaryTreeNode<>(10);
        tree.right.right.left = new BinaryTreeNode<>(9);
        tree.right.left = new BinaryTreeNode<>(5);
        tree.right.left.left = new BinaryTreeNode<>(2);
        tree.right.left.right = new BinaryTreeNode<>(1);
        tree.left = new BinaryTreeNode<>(20);

        BinaryTreeNode<Integer> subTree = new BinaryTreeNode<>(30);
        subTree.right = new BinaryTreeNode<>(4);
        subTree.right.right = new BinaryTreeNode<>(10);
        subTree.right.left = new BinaryTreeNode<>(9);
        subTree.left = new BinaryTreeNode<>(5);
        subTree.left.left = new BinaryTreeNode<>(2);
        subTree.left.right = new BinaryTreeNode<>(1);

        System.out.println(isSubTree(tree, subTree));
    }
}
