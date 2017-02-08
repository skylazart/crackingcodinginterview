package problems;

/**
 * Created by fsantos on 1/12/17.
 */
public class Prob79 {
    // a and b are sorted
    public static int findMinDelta(int[] a, int[] b) {
        int min = Integer.MAX_VALUE;
        int prev;

        int idxA = 0;
        int idxB = 0;

        if (a[idxA] < b[idxB]) {
            prev = a[idxA++];
        } else {
            prev = a[idxB++];
        }

        while (idxA < a.length && idxB < b.length) {
            if (a[idxA] < b[idxB]) {
                min = Math.min(Math.abs(prev - a[idxA]), min);
                prev = a[idxA];
                idxA++;
            } else {
                min = Math.min(Math.abs(prev - b[idxB]), min);
                prev = b[idxB];
                idxB++;
            }
        }

        while (idxA < a.length) {
            min = Math.min(Math.abs(prev - a[idxA]), min);
            prev = a[idxA];
            idxA++;
        }

        while (idxB < b.length) {
            min = Math.min(Math.abs(prev - b[idxB]), min);
            prev = b[idxB];
            idxB++;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMinDelta(new int[]{-3, 1, 999}, new int[]{-1, 2, 3}));
    }
}
