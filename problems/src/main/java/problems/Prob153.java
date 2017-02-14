package problems;

import java.util.*;

/**
 * Created by fsantos on 2/10/17.
 */
public class Prob153 {
    public static void findFirstUnique(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer c = freqMap.get(arr[i]);
            if (c == null) {
                freqMap.put(arr[i], 1);
                queue.add(arr[i]);
            } else {
                freqMap.put(arr[i], c + 1);

                if (queue.peek() == arr[i])
                    queue.remove();
            }
        }

        boolean found = false;

        while (!queue.isEmpty()) {
            Integer x = queue.remove();
            Integer c = freqMap.get(x);

            if (c == 1 && !found) {
                System.out.println(x);
                // Guarantee to purge to queue
                found = true;
            }
        }
    }

    public static void main(String[] args) {
        findFirstUnique(new int[] {1, 2, 3, 1});
    }
}
