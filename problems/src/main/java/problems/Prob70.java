package problems;

import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 1/6/17.
 */
public class Prob70 {
    public static class Res {
        private boolean found = false;
    }
    public static boolean checkSum(BinaryTreeNode<Integer> root, int wanted) {
        Res res = new Res();
        findSum(root, wanted, res);
        return res.found;
    }

    private static int findSum(BinaryTreeNode<Integer> node, int wanted, Res res) {
        if (node == null) return 0;
        int sumLeft = findSum(node.left, wanted, res);
        int sumRight = findSum(node.right, wanted, res);

        if (sumLeft == wanted || sumRight == wanted) {
            res.found = true;
        }

        if (sumLeft + sumRight == wanted) {
            res.found = true;
        }

        if (sumLeft + sumRight + node.value == wanted) {
            res.found = true;
        }

        if (sumRight + node.value == wanted) {
            res.found = true;
        }

        if (sumLeft + node.value == wanted) {
            res.found = true;
        }

        return sumLeft + sumRight + node.value;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(20);
        root.right = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(5);

        System.out.println(checkSum(root, 17));
    }
}
