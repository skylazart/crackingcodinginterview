package problems;

import problems.auxiliar.BinaryTreeNode;

import java.beans.BeanInfo;
import java.util.*;

/**
 * Created by fsantos on 2/16/17.
 */
public class Prob169 {
    public static class LongestPath <T extends Comparable<T>> {
        List<BinaryTreeNode<T>> longestPath = null;
    }

    public static <T extends Comparable<T>> int binaryTreeDiameter(BinaryTreeNode<T> root) {
        LongestPath<T> longestLeft = new LongestPath<T>();
        List<BinaryTreeNode<T>> tLeft = new ArrayList<>();
        tLeft.add(root);
        longestPath(root.left, longestLeft, tLeft);

        List<BinaryTreeNode<T>> tRight = new ArrayList<>();
        tRight.add(root);
        LongestPath<T> longestRight = new LongestPath<T>();
        longestPath(root.right, longestRight, tRight);

        return longestLeft.longestPath.size() + longestRight.longestPath.size() - 1;
    }

    private static <T extends Comparable<T>> void longestPath(BinaryTreeNode<T> node, LongestPath<T> res,
                                                             List<BinaryTreeNode<T>> path) {
        if (node == null) {
            if (res.longestPath == null) {
                res.longestPath = path;
                return;
            }
            if (path.size() > res.longestPath.size()) {
                res.longestPath = path;
            }
            return;
        }

        List<BinaryTreeNode<T>> l = new ArrayList<>(path);
        List<BinaryTreeNode<T>> r = new ArrayList<>(path);
        l.add(node);
        r.add(node);

        longestPath(node.left, res, l);
        longestPath(node.right, res, r);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(9);
        root.right = new BinaryTreeNode<>(11);
        System.out.println(binaryTreeDiameter(root));
    }
}
