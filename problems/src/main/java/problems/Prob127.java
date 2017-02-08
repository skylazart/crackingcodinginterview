package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob127 {
    public static class Res {
        private int sum;
        private int K;

        public Res(int K) {
            this.K = K;
        }

        public void add(int x) {
            if (K <= 0) return;
            sum += x;
            K--;
        }

        public boolean done() {
            return K <= 0;
        }
    }
    public static int sumOfKthSmallest(BinaryTreeNode<Integer> root, int K) {
        Res res = new Res(K);
        dfsInOrder(root, res);
        return res.sum;
    }

    public static void dfsInOrder(BinaryTreeNode<Integer> node, Res res) {
        if (node == null) return;

        dfsInOrder(node.left, res);
        if (!res.done())
            res.add(node.value);
        else
            return;

        dfsInOrder(node.right, res);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBST();
        System.out.println(sumOfKthSmallest(root, 3));
    }
}
