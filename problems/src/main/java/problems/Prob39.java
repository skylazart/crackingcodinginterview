package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fsantos on 12/8/16.
 */
public class Prob39 {
    private int idx1;
    private int idx2;

    public Prob39(int[] arr, int N) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer found = map.get(N - arr[i]);
            if (found != null) {
                idx1 = i;
                idx2 = found;
                break;
            } else {
                map.put(arr[i], i);
            }
        }
    }

    public int getIdx1() {
        return idx1;
    }

    public int getIdx2() {
        return idx2;
    }

    public static void main(String[] args) {
        Prob39 prob39 = new Prob39(new int[]{1, 2, 3, 4, 5, -1, 1, 1}, 3);
        System.out.println(prob39.getIdx1());
        System.out.println(prob39.getIdx2());
    }
}

