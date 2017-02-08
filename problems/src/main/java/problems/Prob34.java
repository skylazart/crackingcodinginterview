package problems;

/**
 * Created by fsantos on 12/5/16.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array, how would you find all contiguous subsequences with a particular sum?
 * Again, think about the duplicated work in the brute-force algorithm.
 */
public class Prob34 {

    /* 1 2 3 9 4 2 2 2 4
       -----
               ---
                 -----
                     ---

       1 3 6 15 19 21 23 25 29
    */

    public static int findSubsequencesThatSumUpTo(int[] arr, int neededSum) {
        int total = 0;

        Set<Integer> set = new HashSet<>();

        int acc = 0;
        for (int i = 0; i < arr.length; i++) {
            acc += arr[i];
            set.add(acc);
        }

        for (Integer x: set) {
            if (x == neededSum) {
                total++;
            }

            int required = x + neededSum;
            if (set.contains(required)) {
                total++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(findSubsequencesThatSumUpTo(new int[]{1, 2, 3, 9, 4, 2, 2, 2, 4, 1, 1, 1, 1, 1, 1}, 6));
    }
}
