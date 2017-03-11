package problems;

import problems.auxiliar.ArrayUtils;
import problems.auxiliar.BinaryTreeNode;

/**
 * Created by fsantos on 2/16/17.
 */
public class Prob167 {
    /*
    [5,3,2,4,8,7,9]


                 5
             3        8
          2     4    7 9
        1           6
     */

    public static void findLeafs(int[] arr) {
        int leftBegin = 0;
        int leftEnd = findNextBigger(arr, arr[0]) - 1;
        int rightBegin = leftEnd + 1;
        int rightEnd = arr.length - 1;

        findLeafsLeft(arr, 1, leftEnd, Integer.MIN_VALUE, arr[0]);
    }

    public static void findLeafsLeft(int[] arr, int leftBegin, int leftEnd, int min, int max) {

    }

    public static int findNextBigger(int[] arr, int value) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > value)
            return i;
        }
        return -1;
    }

    public static int findRight(int[] arr, int headValue) {
        int i = 1;
        while (i < arr.length && arr[i] < headValue)
            i++;

        return i;
    }

    public static void main(String[] args) {
        findLeafs(new int[] {5, 3, 2, 1, 4, 8, 6, 7, 9});
    }
}
