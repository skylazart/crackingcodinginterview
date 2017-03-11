package problems;

/**
 * Created by fsantos on 2/21/17.
 */
public class Prob172 {
    public static boolean findSubArraySumToN(int[] arr, int N) {
        int[] t = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                t[j] += i;
                if (t[j] == N) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSubArraySumToN(new int[]{1, 1, 1, 1, 1}, 8));
    }
}
