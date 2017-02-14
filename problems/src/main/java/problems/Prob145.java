package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;
import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob145 {
    public static <T extends Comparable<T>> void findCommons(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2) {
        Set<T> set = new HashSet<T>();
        dfs(t1, set);
        dfs(t2, set);
    }

    private static <T extends Comparable<T>> void dfs(BinaryTreeNode<T> node, Set<T> set) {
        if (node == null) return;

        if (set.contains(node.value))
            System.out.println(node.value);

        set.add(node.value);
        dfs(node.right, set);
        dfs(node.left, set);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> t1 = BinaryTreeFactory.makeBinaryTreeFromList(new Integer[]{1, 2, 3, 4});
        BinaryTreeNode<Integer> t2 = BinaryTreeFactory.makeBinaryTreeFromList(new Integer[]{9, 5, 1, 3, 4, 99});
        findCommons(t1, t2);
    }
}
