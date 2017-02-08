package problems;

import problems.auxiliar.BinaryTreeNode;
import java.util.*;

/**
 * Created by fsantos on 2/7/17.
 */
public class Prob139 {
    public static class Res {
        private List<List<BinaryTreeNode<Integer>>> listOfPaths = new ArrayList<>();
        public Res() {

        }

        public void addList(List<BinaryTreeNode<Integer>> path) {
            listOfPaths.add(path);
        }

        public void printPaths() {
            for (List<BinaryTreeNode<Integer>> l: listOfPaths) {
                System.out.print("PATH: ");
                for (BinaryTreeNode<Integer> n: l) {
                    System.out.print(n.value + ", ");
                }
                System.out.println();
            }
        }
    }

    public static void simpleFindSumUpToK(BinaryTreeNode<Integer> node, int K) {
        if (node == null)
            return;

        Res res = new Res();
        List<BinaryTreeNode<Integer>> path = new ArrayList<>();
        dfs(node, K, 0, path, res);
        res.printPaths();

        simpleFindSumUpToK(node.left, K);
        simpleFindSumUpToK(node.right, K);
    }

    private static void dfs(BinaryTreeNode<Integer> node, int K, int sum, List<BinaryTreeNode<Integer>> path, Res res) {
        if (node == null)
            return;

        path.add(node);
        sum += node.value;

        if (sum == K) {
            res.addList(path);
            return;
        }

        List<BinaryTreeNode<Integer>> pathToLeft = new ArrayList<>(path);
        List<BinaryTreeNode<Integer>> pathToRight = new ArrayList<>(path);

        dfs(node.left, K, sum, pathToLeft, res);
        dfs(node.right, K, sum, pathToRight, res);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(1);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.left.left = new BinaryTreeNode<>(-1);
        root.right.left.left.right = new BinaryTreeNode<>(1);
        simpleFindSumUpToK(root, 3);
    }
}
