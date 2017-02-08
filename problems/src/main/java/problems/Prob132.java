package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 2/6/17.
 */
public class Prob132 {
    public static int findSubArrays(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            count += check(arr, i);
        }

        return count;
    }

    private static int check(int[] arr, int begin) {
        int[] t = new int[arr.length - begin];
        int out = 0;
        int acc = 0;
        int zeroCount = 0;

        for (int i = begin; i < arr.length; i++) {
            acc += arr[i];
            t[out] = acc;

            if (acc == 0)
                zeroCount++;

            out++;
        }

        return zeroCount;
    }

    public static void main(String[] args) {
        System.out.println(findSubArrays(new int[] {-1, 1, -1, 1}));
    }
}
