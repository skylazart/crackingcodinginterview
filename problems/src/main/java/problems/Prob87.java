package problems;

import problems.auxiliar.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fsantos on 1/17/17.
 */
public class Prob87 {
    public static <T extends Comparable<T>> List<BinaryTreeNode<T>> pathTo(BinaryTreeNode<T> root, T needed) {
        Res<T> res = new Res<>();
        dfs(root, needed, new ArrayList<>(), res);
        return res.path;
    }

    private static <T extends Comparable<T>> void dfs(BinaryTreeNode<T> node, T needed,
                                                      List<BinaryTreeNode<T>> path,
                                                      Res<T> res) {
        if (node == null) return;

        List<BinaryTreeNode<T>> temp = new ArrayList<>(path);
        temp.add(node);

        System.out.println(node.value);

        if (needed.compareTo(node.value) == 0) {
            if (res.path == null)
                res.path = temp;

            return;
        }

        if (res.path != null) return;
        dfs(node.left, needed, temp, res);
        if (res.path != null) return;
        dfs(node.right, needed, temp, res);
    }

    private static class Res <T extends Comparable<T>> {
        private List<BinaryTreeNode<T>> path;

        public Res() {

        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);
        root.left = new BinaryTreeNode<>(1);
        root.left.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(4);
        root.right = new BinaryTreeNode<>(2);
        root.right.left = new BinaryTreeNode<>(5);

        List<BinaryTreeNode<Integer>> pathToFour = pathTo(root, 4);
        List<BinaryTreeNode<Integer>> pathToFive = pathTo(root, 5);

        Set<Integer> visited = new HashSet<>();

        for (BinaryTreeNode<Integer> node: pathToFour) {
            visited.add(node.value);
        }

        for (int i = pathToFive.size() - 1; i >= 0; i--) {
            BinaryTreeNode<Integer> node = pathToFive.get(i);
            if (visited.contains(node.value)) {
                System.out.println("LCA is " + node.value);
                break;
            }
        }
    }
}
