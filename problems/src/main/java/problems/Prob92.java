package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob92 {
    /*
    {0, 0, 0, 1, 2, 3}
     */
    public static void moveZerosToTheEnd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0 && arr[right] != 0) {
                exchange(arr, left, right);
                left++;
                right--;
                continue;
            }

            if (arr[left] != 0)
                left++;

            if (arr[right] == 0)
                right--;
        }
    }

    private static void exchange(int[] arr, int from, int to) {
        int t = arr[from];
        arr[from] = arr[to];
        arr[to] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 0, 1, 2, 3, 4};
        ArrayUtils.printArr(arr, ", ");
        moveZerosToTheEnd(arr);
        ArrayUtils.printArr(arr, ", ");
    }
}
