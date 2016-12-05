package problems;

/**
 * Created by fsantos on 12/5/16.
 */

/**
 * Merge two sorted arrays
 */

/*

arr1[3] = {1, 3, 5}
arr2[4] = {0, 2, 4, 6}
merged[7] = {}

itM = 0
itA1 = 0
itA2 = 0
merged[7] = {}

itM = 1
itA1 = 0
itA2 = 1
merged[7] = {0}

 */
public class Prob30 {
    public static int[] merge(int[] arr1, int[] arr2) {
        // Sanity Checking
        if (arr1 == null) return arr2;
        if (arr2 == null) return arr1;

        int merged[] = new int[arr1.length + arr2.length];

        int itMerged = 0;
        int itA1 = 0;
        int itA2 = 0;

        while (itA1 < arr1.length && itA2 < arr2.length) {
            if (arr1[itA1] < arr2[itA2]) {
                merged[itMerged++] = arr1[itA1++];
            } else {
                merged[itMerged++] = arr2[itA2++];
            }
        }

        // Filling with elements left in arr1 or arr2
        while (itA1 < arr1.length) {
            merged[itMerged++] = arr1[itA1++];
        }

        while (itA2 < arr2.length) {
            merged[itMerged++] = arr2[itA2++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] merged = merge(new int[]{1, 3, 5}, new int[]{0, 2, 4, 6});
        for (int i = 0; i < merged.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(merged[i]);
        }
    }
}
