package problems;

import problems.auxiliar.ArrayUtils;

import java.lang.reflect.Array;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob94 {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int j = partition(arr, left, right);
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right + 1;
        int v = arr[left];

        while (true) {
            while (arr[++i] < v) if (i == right) break;
            while (v < arr[--j]) if (j == left) break;
            if (i >= j) break;
            exch(arr, i, j);
        }

        exch(arr, left, j);
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 3, 9, 7, 4};
        ArrayUtils.printArr(arr, ", ");
        quickSort(arr);
        ArrayUtils.printArr(arr, ", ");
    }
}
