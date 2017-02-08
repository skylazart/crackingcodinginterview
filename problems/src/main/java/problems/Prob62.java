package problems;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob62 {
    //

    /*
    sorted[] = 1 3 6 7 8 9
    x = 5
    closest = -99999;

    wanted = 5 - 1 => 4
    lowerBound = 1
    sum = 1 + 3 => 4
     */
    public static int findPairSumClosestTo(int[] sorted, int x) {
        int closest = Integer.MIN_VALUE;

        for (int i = 0; i < sorted.length; i++) {
            int wanted = x - sorted[i];
            int lowerBound = findLowerBound(sorted, wanted);

            int sum = sorted[i] + sorted[lowerBound];
            if (sum < x) {
                closest = Math.max(sum, closest);
            } else {
                break;
            }
        }

        return closest;
    }

    public static int findLowerBound(int[] sorted, int wanted) {
        int left = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int mid = findMidPoint(left, right);

            if (wanted == sorted[mid])
                return mid;

            if (wanted < sorted[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        if (left == 0) return left;
        else return left - 1;
    }

    public static int findMidPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        int[] sorted = new int[]{1, 3, 6, 7, 8, 9};
        System.out.println(findPairSumClosestTo(sorted, 5));
    }
}
