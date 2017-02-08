package problems;

import java.util.Arrays;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob68 {
    /*
    1 2 3 4 8
     */
    public static int longestConsSubArray(int[] arr) {
        Arrays.sort(arr);
        int len = 1;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                if (len > 0)
                    maxLen = Math.max(maxLen, len);
                len = 1;
            } else {
                len++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestConsSubArray(new int[]{1, 2, 3, 4, 8}));
    }
}
