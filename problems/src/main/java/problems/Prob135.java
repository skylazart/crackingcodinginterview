package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 2/6/17.
 */
public class Prob135 {
    public static int sumOfMinMaxSubArray(int[] arr, int k) {
        if (k > arr.length) throw new IllegalStateException("Invalid argument length");
        int acc = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            acc += sum(arr, i, k);
        }

        return acc;
    }

    private static int sum(int[] arr, int begin, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = begin; i < begin + k; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        return min + max;
    }

    public static int sumOfMinMaxSubArrayV2(int[] arr, int k) {
        int max[] = new int[arr.length];
        int min[] = new int[arr.length];

        int tempMin = Integer.MAX_VALUE;
        int tempMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            tempMax = Math.max(tempMax, arr[i]);
            tempMin = Math.min(tempMin, arr[i]);
            max[i] = tempMax;
            min[i] = tempMin;
        }

        int acc = 0;
        for (int i = k - 1; i < arr.length; i++) {
            acc += max[i] + min[i];
        }

        return acc;
    }

    /*
         2, 5, -1, 7, -3, -1, -2

    min: 2, 2, -1, -1, -3, -3, -3
    max: 2, 5, 5, 7, 7, 7, 7
     */

    public static void main(String[] args) {
        System.out.println(sumOfMinMaxSubArray(new int[] {2, 5, -1, 7, -3, -1, -2}, 4));
        System.out.println(sumOfMinMaxSubArrayV2(new int[] {2, 5, -1, 7, -3, -1, -2}, 4));
    }

}
