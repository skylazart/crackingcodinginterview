package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsantos on 1/31/17.
 */
public class Prob114 {
    public static class Inc {
        private int count = 1;

        public Inc() {

        }

        public void inc() {
            count++;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 1, 2, 3};
        Map<Integer, Inc> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Inc inc = freqMap.get(arr[i]);
            if (inc == null)
                freqMap.put(arr[i], new Inc());
            else
                inc.inc();
        }

        for (int i = 0; i < arr.length; i++) {
            Inc inc = freqMap.get(arr[i]);
            if (inc.count == 1) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
