package problems;

import problems.auxiliar.BinaryTreeNode;
import java.util.*;

/**
 * Created by fsantos on 2/1/17.
 */
public class Prob118 {
    public static void findPathsSumUpToKFromRoot(BinaryTreeNode<Integer> root, int K) {
        List<BinaryTreeNode<Integer>> path = new ArrayList<>();
        dfs(root, path, 0, K);
    }

    private static void dfs(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> path, int sum, int K) {
        if (node == null) return;

        path.add(node);
        sum += node.value;

        if (sum == K) {
            printPath(path);
            return;
        }

        List<BinaryTreeNode<Integer>> leftPath = new ArrayList<>(path);
        List<BinaryTreeNode<Integer>> rightPath = new ArrayList<>(path);
        dfs(node.right, leftPath, sum, K);
        dfs(node.left, rightPath, sum, K);
    }

    private static void printPath(List<BinaryTreeNode<Integer>> path) {
        System.out.println("PATH:");
        for (BinaryTreeNode<Integer> node: path)
            System.out.println(node.value);
    }

    /*
         1
       /   \
     20      3
           /    \
         4       15
        /  \     /  \
       6    7   8    9


         10
       /     \
     28       13
           /     \
         14       15
        /   \     /  \
       21   22   23   24

     */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(7);
        root.right = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(15);
        root.right.right.right = new BinaryTreeNode<>(9);
        root.right.right.left = new BinaryTreeNode<>(8);
        root.right.left = new BinaryTreeNode<>(4);
        root.right.left.right = new BinaryTreeNode<>(7);
        root.right.left.left = new BinaryTreeNode<>(6);

        findPathsSumUpToKFromRoot(root, 8);
    }
}
