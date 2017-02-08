package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/3/17.
 */
public class Prob53 {
    public static boolean checkArray(BinaryTreeNode<Integer> root, int[] arr) {
        if (root == null && arr.length == 0) return true;
        if (root == null && arr.length > 0) return false;

        return dfsPre(root, arr, 0);
    }

    private static boolean dfsPre(BinaryTreeNode<Integer> node, int[] arr, int i) {
        if (node == null) {
            return true;
        }

        System.out.println(node.value + " i = " + i + " arr[i]" + arr[i]);
        if (node.value != arr[i])
            return false;

        i++;
        boolean left = dfsPre(node.left, arr, i);
        i++;
        boolean right = dfsPre(node.right, arr, i);

        return left && right;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(3);
        root.left = new BinaryTreeNode<>(1);

        System.out.println(checkArray(root, new int[]{2, 1, 4, 3}));
    }
}
