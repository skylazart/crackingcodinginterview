package problems;

import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

import java.util.*;

/**
 * Created by fsantos on 2/8/17.
 */
public class Prob144 {
    public static Integer findMaxElementBetweenTwoNodes(BinaryTreeNode<Integer> root, Integer a, Integer b) {
        int max = Integer.MIN_VALUE;
        boolean foundFirst = false;
        boolean foundSecond = false;

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> current = root;

        while (current != null) {
            if (!foundFirst) if (current.value.compareTo(a) == 0) foundFirst = true;
            if (foundFirst & !foundSecond) max = Math.max(max, current.value);
            if (!foundSecond) if (current.value.compareTo(b) == 0) foundSecond = true;
            if (foundSecond) break;

            stack.push(current);
            current = current.left;
        }

        if (foundSecond)
            return max;

        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> x = stack.pop();

            if (!foundFirst) if (x.value.compareTo(a) == 0) foundFirst = true;
            if (foundFirst & !foundSecond) max = Math.max(max, x.value);
            if (!foundSecond) if (x.value.compareTo(b) == 0) foundSecond = true;
            if (foundSecond) break;

            if (x.right != null) {
                x = x.right;

                while (x != null) {
                    if (!foundFirst) if (x.value.compareTo(a) == 0) foundFirst = true;
                    if (foundFirst & !foundSecond) max = Math.max(max, x.value);
                    if (!foundSecond) if (x.value.compareTo(b) == 0) foundSecond = true;
                    if (foundSecond) break;

                    stack.push(x);
                    x = x.left;
                }
            }
        }

        // Empty the stack
        while (!stack.isEmpty())
            stack.pop();


        return max;
    }

    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, Integer value) {
        if (node == null) return new BinaryTreeNode<>(value);
        if (value.compareTo(node.value) > 0)
            node.right = insert(node.right, value);
        else
            node.left = insert(node.left, value);

        return node;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = null;

        for (Integer x: Arrays.asList(18, 36, 9, 6, 12, 10, 1, 8)) {
            root = insert(root, x);
        }

        BinaryTreeUtils.printLevelOrder(root);

        System.out.println(findMaxElementBetweenTwoNodes(root, 1, 10));
    }
}
