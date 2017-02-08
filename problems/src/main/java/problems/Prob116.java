package problems;

import problems.auxiliar.ArrayUtils;

/**
 * Created by fsantos on 2/1/17.
 */
public class Prob116 {
    public static int findMaxConsecutivesOnes(int[] arr) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutivesOnes(arr));
    }
}
