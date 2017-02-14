package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;
import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob147 {
    public static int floor(BinaryTreeNode<Integer> root, int value) {
        return dfsFloor(root, value, root.value < value ? root.value : -1);
    }

    private static int dfsFloor(BinaryTreeNode<Integer> node, int value, int floor) {
        if (node == null) return floor;

        if (node.value == value)
            floor = node.value;

        if (node.value < value && node.value > floor)
            floor = node.value;

        if (value > node.value)
            return dfsFloor(node.right, value, floor);
        else
            return dfsFloor(node.left, value, floor);
    }

    public static int ceiling(BinaryTreeNode<Integer> root, int value) {
        return dfsCeiling(root, value, root.value > value ? root.value : -1);
    }

    public static int dfsCeiling(BinaryTreeNode<Integer> node, int value, int ceil) {
        if (node == null) return ceil;

        if (node.value == value)
            ceil = node.value;

        if (node.value > value) {
            if (ceil == -1) ceil = node.value;
            ceil = Math.min(ceil, node.value);
        }

        if (value > node.value)
            return dfsCeiling(node.right, value, ceil);
        else
            return dfsCeiling(node.left, value, ceil);
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer x: Arrays.asList(4, 3, 6, 1, 8, 9, 2)) {
            treeSet.add(x);
        }

        /*
        System.out.println("Floor: " + treeSet.floor(7));
        System.out.println("Ceiling: " + treeSet.ceiling(7));

        System.out.println("Floor: " + treeSet.floor(8));
        System.out.println("Ceiling: " + treeSet.ceiling(8));

        Floor: 6
        Ceiling: 8
        Floor: 8
        Ceiling: 8
         */

//        System.out.println("Floor: " + treeSet.floor(7));
//        System.out.println("Ceiling: " + treeSet.ceiling(7));
//
//        System.out.println("Floor: " + treeSet.floor(8));
//        System.out.println("Ceiling: " + treeSet.ceiling(8));

        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTreeFromList(new Integer[]{4, 3, 6, 1, 8, 9, 2});
        System.out.println(floor(root, 7));
        System.out.println(ceiling(root, 7));

    }
}
