package problems;

import problems.auxiliar.BinaryTreeFactory;
import problems.auxiliar.BinaryTreeNode;
import problems.auxiliar.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by fsantos on 1/17/17.
 */
public class Prob88 {
    /*
    Find sum of n elements after kth smallest element in BST.
    Tree is very large, you are not allowed to traverse the tree.
     */
    public static int findSum(BinaryTreeNode<Integer> root, int N, int K) {
        int sum = 0;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

        BinaryTreeNode<Integer> current = root;

        // Going left
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        // Returning and going right
        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> elmt = stack.pop();
            System.out.println(elmt.value);

            N--;
            if (N < 0) {
                sum += elmt.value;
                if (--K == 0) break;
            }

            if (elmt.right != null) {
                BinaryTreeNode<Integer> t = elmt.right;

                while (t != null) {
                    stack.push(t);
                    t = t.left;
                }
            }
        }

        // Cleanup stack
        while (!stack.isEmpty())
            stack.pop();

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 100; i++)
            list.add(i);

        Collections.shuffle(list);
        Integer[] arr = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);

        BinaryTreeNode<Integer> root = BinaryTreeFactory.makeBinaryTreeFromList(arr);
        BinaryTreeUtils.printLevelOrder(root);

        System.out.println(findSum(root, 3, 3));
    }
}
