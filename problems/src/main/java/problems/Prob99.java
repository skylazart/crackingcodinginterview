package problems;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob99 {
    public static int findMissingElement(int[] arr1, int[] arr2) throws IllegalStateException {
        int max = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < max; i++) {
            if (arr1[i] != arr2[i])
                return arr1[i];
        }

        throw new IllegalStateException("Not found");
    }
}
