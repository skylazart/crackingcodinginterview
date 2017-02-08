package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob121 {
    public static int findMaxLevelSum(BinaryTreeNode<Integer> root) {
        int maxSum = Integer.MIN_VALUE;
        int currentLevelSum = 0;

        int currentCounter = 1;
        int nextCounter = 0;

        Queue<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.remove();
            currentCounter--;

            currentLevelSum += node.value;

            if (node.left != null) {
                queue.add(node.left);
                nextCounter++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextCounter++;
            }

            if (currentCounter == 0) {
                maxSum = Math.max(maxSum, currentLevelSum);
                currentLevelSum = 0;
                currentCounter = nextCounter;
                nextCounter = 0;
            }
        }

        return maxSum;
    }

    /*
    Input :           4
                    /   \
                   2    -5
                  / \    /\
                -1   3 -2  6
     */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        root.left = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(-1);
        root.left.right = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(-5);
        root.right.left = new BinaryTreeNode<>(-2);
        root.right.right = new BinaryTreeNode<>(6);

        //BinaryTreeUtils.printLevelOrder(root);
        System.out.println(findMaxLevelSum(root));

    }
}
