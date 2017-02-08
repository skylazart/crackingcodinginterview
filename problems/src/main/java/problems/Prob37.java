package problems;

/**
 * Created by fsantos on 12/7/16.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of numbers. Print all the pairs (2) of numbers in the array if the sum of those
 * numbers is also present in the array.
 */
public class Prob37 {
    public static void findSumOfPairs(int[] arr, int N) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int needed = N - x;
            if (set.contains(needed)) {
                System.out.println("Pair: " + x + ", " + needed);
            } else {
                set.add(x);
            }
        }
    }

    public static void findSumOfThree(int[] arr, int N) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                int needed = N - sum;

                if (set.contains(needed))
                    System.out.println(arr[i] + " + " + arr[j] + " + " + needed);

                set.add(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        findSumOfPairs(new int[]{1, 2, 3, 4, 5, 6, 7, 2}, 4);
        findSumOfThree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, -1}, 6);
    }
}
