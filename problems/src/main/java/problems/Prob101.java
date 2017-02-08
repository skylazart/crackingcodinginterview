package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob101 {
    public static int[] customSort(int[] arr, int K) {
        int temp[] = new int[arr.length];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < K)
                temp[j++] = arr[i];
        }

        temp[j++] = K;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > K)
                temp[j++] = arr[i];
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 7, 9, 5, 4, 3, 7};
        int[] sorted = customSort(arr, 5);
        ArrayUtils.printArr(sorted, ", ");
    }
}
