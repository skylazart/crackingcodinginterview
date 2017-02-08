package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsantos on 1/31/17.
 */
public class Prob113 {
    public static class Res {
        private List<BinaryTreeNode<Integer>> path = null;
        private int weight = Integer.MAX_VALUE;

        public Res() {

        }
    }

    public static List<BinaryTreeNode<Integer>> findLighterPath(BinaryTreeNode<Integer> root) {
        Res res = new Res();
        List<BinaryTreeNode<Integer>> path = new ArrayList<>();
        dfs(root, path, res);
        return res.path;
    }

    private static void dfs(BinaryTreeNode<Integer> node, List<BinaryTreeNode<Integer>> path, Res res) {
        if (node == null) {
            int weight = calculateWeight(path);
            if (weight < res.weight) {
                res.path = path;
                res.weight = weight;
            }
            return;
        }

        path.add(node);
        List<BinaryTreeNode<Integer>> leftPath = new ArrayList<>(path);
        List<BinaryTreeNode<Integer>> rightPath = new ArrayList<>(path);
        dfs(node.left, leftPath, res);
        dfs(node.right, rightPath, res);
    }

    private static int calculateWeight(List<BinaryTreeNode<Integer>> path) {
        int weight = 0;
        for (BinaryTreeNode<Integer> node: path)
            weight += node.value;

        return weight;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTree();
        List<BinaryTreeNode<Integer>> lighterPath = findLighterPath(root);

        for (BinaryTreeNode<Integer> node: lighterPath)
            System.out.println(node.value);

    }
}
