package problems;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by fsantos on 1/5/17.
 */
public class Prob64 {
    /*
    Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3)
     */

    /*
     arr[] = {-2, 0, 1, 3}
     sum[] = {}


     */

    public static int countTripleSumSmaller(int[] arr, int N) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                int maxWanted = N - sum;

                for (int k = j + 1; k < arr.length; k++) {
                    if (maxWanted < arr[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTripleSumSmaller(new int[]{-2, 1, 2, 3}, 2));
    }
}
