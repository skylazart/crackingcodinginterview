package problems;

import java.util.*;

/**
 * Created by fsantos on 2/10/17.
 */
public class Prob154 {
    public static void findUniqueSubArray(int[] arr, int K) {
        // Sanity checking
        if (K > arr.length)
            return;

        for (int i = 0; i < arr.length - (K - 1); i++) {
            int c = findUniqueElements(arr, i, i + (K - 1));
            System.out.println(c);
        }
    }

    private static int findUniqueElements(int[] arr, int begin, int end) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = begin; i <= end; i++) {
            Integer c = freq.get(arr[i]);
            if (c == null) {
                freq.put(arr[i], 1);
            } else {
                freq.put(arr[i], c + 1);
            }
        }


        int count = 0;
        for (Map.Entry<Integer, Integer> keyValeu: freq.entrySet()) {
            //dSystem.out.println(keyValeu.getKey() + " -> " + keyValeu.getValue());
            if (keyValeu.getValue() == 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        findUniqueSubArray(new int[]{1, 1, 1, 1, 2}, 2);
    }
}
