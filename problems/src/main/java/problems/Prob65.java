package problems;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob65 {
    /*
    Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
     */

    public static Prob61.Pair<Integer, Integer> findSumOfTwoClosest(int[] sorted, int K) throws PairNotFoundException {
        int left = 0;
        int right = sorted.length - 1;

        int closest = Integer.MAX_VALUE;
        int x = -1;
        int y = -1;

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == K) return new Prob61.Pair<>(sorted[left], sorted[right]);

            if (Math.abs(sum - K) < closest) {
                closest = Math.abs(sum - K);
                // Save indexes
                x = left;
                y = right;
            }

            if (sum > K) {
                right--;
            } else {
                left++;
            }
        }

        return new Prob61.Pair<>(sorted[x], sorted[y]);
    }

    public static Prob61.Triple<Integer, Integer, Integer> findSumOfThreeClosest(int[] sorted, int K)
            throws PairNotFoundException {

        int closest = Integer.MAX_VALUE;
        int a = -1;
        int b = -1;
        int c = -1;

        for (int i = 0; i < sorted.length && sorted[i] < K; i++) {
            int wanted = K - sorted[i];

            try {
                Prob61.Pair<Integer, Integer> pair = findSumOfTwoClosest(sorted, wanted);
                int sumOfThree = pair.getA() + pair.getB() + sorted[i];

                int absDiff = Math.abs(sumOfThree - K);
                if (absDiff < closest) {
                    closest = absDiff;
                    a = pair.getA();
                    b = pair.getB();
                    c = sorted[i];
                }
            } catch (PairNotFoundException e) {

            }
        }

        return new Prob61.Triple<>(a, b, c);
    }

    private static class PairNotFoundException extends Throwable {
    }

    public static void main(String[] args) throws PairNotFoundException {
        int[] sorted = new int[]{10, 22, 28, 29, 30, 40};
        System.out.println(findSumOfTwoClosest(sorted, 54));
        System.out.println(findSumOfThreeClosest(sorted, 94));
    }
}
