package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsantos on 2/2/17.
 */
public class Prob122 {
    public static class Res {
        private Map<Integer, Integer> freq = new HashMap<>();
        public Res() {

        }

        public void addPathLen(int len) {
            Integer count = freq.get(len);
            if (count == null)
                freq.put(len, 1);
            else
                freq.put(len, count + 1);
        }
    }

    public static <T extends Comparable<T>> void countPathWithSameLength(BinaryTreeNode<T> root) {
        Res res = new Res();
        dfs(root, res, 0);

        for (Map.Entry<Integer, Integer> entry: res.freq.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println("Len: " + entry.getKey() + " Total: " + entry.getValue());
            }
        }
    }

    private static <T extends Comparable<T>> void dfs(BinaryTreeNode<T> node, Res res, int len) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.addPathLen(len);
            return;
        }

        dfs(node.left, res, len + 1);
        dfs(node.right, res, len + 1);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);

        countPathWithSameLength(root);
    }
}
