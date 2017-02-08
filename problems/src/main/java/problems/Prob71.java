package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fsantos on 1/9/17.
 */
public class Prob71 {
    /*
arr[] = {1, 4, 45, 6, 0, 19}
x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}
     */
    public static class SubArraySum implements Comparable<SubArraySum> {
        private final int sum;
        private final int len;
        private final int i;
        private final int j;

        public SubArraySum(int sum, int len, int i, int j) {
            this.sum = sum;
            this.len = len;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(SubArraySum o) {
            if (len != o.len)
                return len - o.len;

            return sum - o.sum;
        }

        @Override
        public String toString() {
            return "[sum: " + sum + ", len: " + len + ", i: " + i + ", j: "  + j + "]";
        }
    }
    public static int[] findSmallestSubArrayWithSumGreaterThanX(int[] arr, int N) {
        List<SubArraySum> list = new ArrayList<>();

        int acc;

        for (int i = 0; i < arr.length; i++) {
            acc = arr[i];

            if (acc > N) list.add(new SubArraySum(acc, 1, i, i));

            for (int j = i + 1; j < arr.length; j++) {
                acc += arr[j];
                if (acc > N) list.add(new SubArraySum(acc, (j - i) + 1, i, j));
            }
        }

        Collections.sort(list);
        for (SubArraySum s: list)
            System.out.println(s);

        System.out.println("--/--");
        return null;
    }

    public static void main(String[] args) {
        findSmallestSubArrayWithSumGreaterThanX(new int[] {1, 4, 45, 6, 0, 19}, 51);
        findSmallestSubArrayWithSumGreaterThanX(new int[] {1, 10, 5, 2, 7}, 9);
    }
}
