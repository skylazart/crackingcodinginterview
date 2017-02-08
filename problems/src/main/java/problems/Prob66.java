package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob66 {
    /*
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

{4, 3, 7, 8, 6, 2, 1}

{3, 4, 7, 8, 2, 6, 1}

     */

    public static void zigZag(int[] arr) {
        boolean zigZag = false;

        for (int i = 0; i < arr.length - 1; i+= 2) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }

        for (int i = 1; i < arr.length - 1; i+= 2) {
            if (arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {4, 3, 7, 8, 6, 2, 1};
        zigZag(arr);
        ArrayUtils.printArr(arr, ", ");

        int arr2[] = new int[] {1, 4, 3, 2};
        zigZag(arr2);

        ArrayUtils.printArr(arr2, ", ");
    }
}
