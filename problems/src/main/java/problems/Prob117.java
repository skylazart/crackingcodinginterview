package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 2/1/17.
 */
public class Prob117 {
    /*
    5 4 3 7 4 1 2 8 10

min 5 4 3 3 3 1 1 1 1
max 5 5 5 7 7 7 7 8 10
     */
    public static int find(int[] arr) {
        int[] max = new int[arr.length];

        int savedMin = Integer.MAX_VALUE;
        int savedMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            savedMax = Math.max(savedMax, arr[i]);
            savedMin = Math.min(savedMin, arr[i]);
            max[i] = savedMax;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > max[i - 1] && arr[i] < max[i + 1])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 7, 4, 1, 2, 8, 10};
        int idx = find(arr);
        if (idx != -1)
            System.out.println(arr[idx]);
    }
}
