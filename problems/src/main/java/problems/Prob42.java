package problems;

import java.util.Arrays;

/**
 * Created by fsantos on 12/24/16.
 */
public class Prob42 {
    /*
    a[-3, 1, 999]
    b[-1, 2, 3]
     */
    public static int[] mergeInOrder(int[] a, int[]b) {
        int[] merged = new int[a.length + b.length];
        System.arraycopy(a, 0, merged, 0, a.length);
        System.arraycopy(b, 0, merged, a.length, b.length);
        Arrays.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        int[] a = new int[] {-3, 1, 999};
        int[] b = new int[] {-1, 3, 996};

        int min = Integer.MAX_VALUE;

        int[] merged = mergeInOrder(a, b);

        for (int i = 1; i < merged.length; i++) {
            min = Math.min(min, Math.abs(merged[i] - merged[i - 1]));
        }

        System.out.println(min);
    }
}
