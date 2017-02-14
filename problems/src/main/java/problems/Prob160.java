package problems;

import problems.auxiliar.ArrayUtils;

import java.util.*;

/**
 * Created by fsantos on 2/12/17.
 */
public class Prob160 {
    /*
    s = [ 1, 2, 3, 4, 5 ]
    target = 5
    op = [ [ 1,4 ] , [2,3] , [5] ]
     */


    public static void linear(int[] arr, int N) {
        int[] acc = new int[arr.length];
        int K = 1;
        Map<Integer, Integer> mapLocation = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < acc.length && j < K) {
                acc[j] += arr[i];
                if (acc[j] == N) {
                    System.out.println("acc[j] = " + acc[j]);
                }

                int needed = N - acc[j];
                if (mapLocation.containsKey(needed)) {
                    System.out.println("acc[j] " + acc[j] + " neeed: " + needed);
                }
                K++;
            }
            mapLocation.put(arr[i], i);
        }
    }
    public static void main(String[] args) {
        linear(new int[]{1, 2, 3, 4, 5}, 5);
    }
}
