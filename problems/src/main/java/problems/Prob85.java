package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 1/17/17.
 */
public class Prob85 {
    public static void printAllPairSumUpToK(int[] arr, int K) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            Integer diff = K - arr[i];
            if (set.contains(diff)) {
                System.out.println(diff + ", " + arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        printAllPairSumUpToK(new int[]{1, 2, 3, 2}, 4);
    }
}
