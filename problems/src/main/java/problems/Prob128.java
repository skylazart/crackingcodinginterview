package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob128 {
    public static class Res {
        private int closest = Integer.MAX_VALUE;
        public Res() {

        }
    }

    public static int findClosest(BinaryTreeNode<Integer> root, int needed) {
        Res res = new Res();
        findClosest(root, needed, res);
        return res.closest;
    }

    private static void findClosest(BinaryTreeNode<Integer> node, int needed, Res res) {
        if (node == null) return;
        if (node.value == needed) {
            res.closest = node.value;
            return;
        }

        if (Math.abs(needed - res.closest) > Math.abs(node.value - needed)) {
            res.closest = node.value;
        }

        if (needed > node.value)
            findClosest(node.right, needed, res);
        else
            findClosest(node.left, needed, res);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBST();
        System.out.println(findClosest(root, 40));
        System.out.println(findClosest(root, 20));
        System.out.println(findClosest(root, 9));
    }
}
