package problems;

import java.util.Arrays;

/**
 * Created by fsantos on 2/1/17.
 */
public class Prob119 {
    /*
Calculate depth of a full Binary tree from Preorder
Input  : nlnll
Output : 2

Input  : nlnnlll
Output : 3
     */

    public static int calculateMaxDepth(String s) {
        return calculateMaxDepth(s, 0, 0);
    }

    private static int calculateMaxDepth(String s, int i, int depth) {
        if (s.charAt(i) == 'l') return depth;

        return Math.max(calculateMaxDepth(s, i + 1, depth + 1),
                calculateMaxDepth(s, i + 2, depth + 1));
    }

    public static void main(String[] args) {
        System.out.println(calculateMaxDepth("nlnll"));
        System.out.println(calculateMaxDepth("nlnnlll"));
    }
}
