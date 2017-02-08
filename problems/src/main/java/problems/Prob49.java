package problems;

import java.util.Arrays;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob49 {
    private static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int[] insertionSort(int[] arr, int n) {
        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 1, arr.length);
        temp[0] = n;

        int i = 1;
        while (i < temp.length && temp[i - 1] > temp[i]) {
            swap(temp, i, i - 1);
            i++;
        }

        return temp;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 3, 5, 4, 6, 9};
        Arrays.sort(arr);
        printArr(arr);
        int newArr[] = insertionSort(arr, 7);
        printArr(newArr);
    }


}
