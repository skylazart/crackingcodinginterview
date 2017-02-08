package problems;

/**
 * Created by fsantos on 1/9/17.
 */
public class Prob73 {
    /*
    {100, 180, 260, 310, 40, 535, 695}
     */
    public static int maxProfit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                max = Math.max(diff, max);
            }
        }
        return max;
    }

    public static int maxProfitV2(int[] arr) {
        int minSoFar = arr[0];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - minSoFar);
            maxDiff = Math.max(diff, maxDiff);
            minSoFar = Math.min(minSoFar, arr[i]);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{100, 180, 260, 310, 40, 535, 695}));
        System.out.println(maxProfitV2(new int[]{100, 180, 260, 310, 40, 535, 695}));
    }
}
