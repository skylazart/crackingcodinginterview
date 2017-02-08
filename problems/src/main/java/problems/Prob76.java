package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 1/12/17.
 */
public class Prob76 {
    /*
    Example
Array 1: 1 2 3 4 5
Array 2: 120 60 40 30 24
     */
    // O(n)
    public static int[] calculate1(int[] arr) {
        int[] output = new int[arr.length];
        int total = multiplyAll(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) output[i] = total;
            output[i] = total / arr[i];
        }

        return output;
    }

    /*
    Array 1: 1 2 3 4 5
    Array 2: 120 60 40 30 24

     */
    // O(n**2)
    public static int[] calculate2(int[] arr) {
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int res = 1;

            for (int j = 0; j < arr.length; j++) {
                if (j == i) continue;
                res *= arr[i] * arr[j];
            }

            output[i] = res;
        }

        return output;
    }

    // O(n) with O(2N) space
    public static int[] calculate3(int[] arr) {
        int[] forward = new int[arr.length];
        int[] backward = new int[arr.length];

        int acc = 1;
        for (int i = 0; i < arr.length; i++) {
            acc *= arr[i];
            forward[i] = acc;
        }

        acc = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            acc *= arr[i];
            backward[i] = acc;
        }

        ArrayUtils.printArr(forward, " - ");
        ArrayUtils.printArr(backward, " - ");

        int[] res = new int[arr.length];
        res[0] = backward[1];
        res[arr.length - 1] = forward[arr.length - 2];

        for (int i = 1; i < arr.length - 1; i++) {
            res[i] = forward[i - 1] * backward[i + 1];
        }
        return res;
    }

    private static int multiplyAll(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;

            res *= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6};
        int[] out = calculate1(arr);
        ArrayUtils.printArr(out, ", ");

        int[] out2 = calculate1(arr);
        ArrayUtils.printArr(out2, ", ");

        int[] out3 = calculate3(arr);
        ArrayUtils.printArr(out3, ", ");
    }
}
