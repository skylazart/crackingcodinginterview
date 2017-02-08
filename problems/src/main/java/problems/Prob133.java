package problems;

import java.util.*;

/**
 * Created by fsantos on 2/6/17.
 */
public class Prob133 {
    public static boolean findSum(int[] a, int[] b, int[] c, int K) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                set.add(a[i] + b[j]);
            }
        }

        for (int i = 0; i < c.length; i++) {
            int wanted = K - c[i];
            if (set.contains(wanted)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSum(
                new int[]{ 1 , 2 , 3 , 4 , 5 },
                new int[]{ 2 , 3 , 6 , 1 , 2 },
                new int[]{ 3 , 2 , 4 , 5 , 6 }, 9));

        System.out.println(findSum(
                new int[]{ 1 , 2 , 3 , 4 , 5 },
                new int[]{ 2 , 3 , 6 , 1 , 2 },
                new int[]{ 3 , 2 , 4 , 5 , 6 }, 20));

    }
}
