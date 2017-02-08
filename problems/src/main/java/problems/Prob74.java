package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsantos on 1/9/17.
 */
public class Prob74 {
    public static class Res <T extends Comparable<T>> {
        private List<BinaryTreeNode<T>> longestPath = new ArrayList<>();
        public Res() {

        }
    }

    public static <T extends Comparable<T>> List<BinaryTreeNode<T>> longestPath(BinaryTreeNode<T> node,
                                                                                List<BinaryTreeNode<T>> path,
                                                                                Res<T> res) {
        if (node == null) {
            if (res.longestPath == null) {
                res.longestPath = path;
            } else if (path.size() > res.longestPath.size()) {
                res.longestPath = path;
            }
            return res.longestPath;
        }

        List<BinaryTreeNode<T>> listLeft = new ArrayList<>(path);
        listLeft.add(node.left);

        List<BinaryTreeNode<T>> listRight = new ArrayList<>(path);
        listRight.add(node.right);

        longestPath(node.left, listLeft, res);
        longestPath(node.right, listRight, res);

        return res.longestPath;
    }

    public static <T extends Comparable<T>> List<BinaryTreeNode<T>> longestPath(BinaryTreeNode<T> root) {
        List<BinaryTreeNode<T>> t = new ArrayList<>();
        t.add(root);
        Res<T> res = new Res();

        List<BinaryTreeNode<T>> list = longestPath(root, t, res);
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTree();
        List<BinaryTreeNode<Integer>> list = longestPath(root);

        for (BinaryTreeNode<Integer> node: list) {
            if (node == null) break;
            System.out.println(node.value);
        }
    }
}
