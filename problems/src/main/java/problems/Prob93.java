package problems;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob93 {
    public static boolean isArithmeticSequence(int[] arr) {
        int sum = arr.length * (arr[0] + arr[arr.length - 1]) / 2;

        int acc = 0;
        for (int x: arr) {
            acc += x;
        }

        return acc == sum;
    }

    public static void main(String[] args) {
        System.out.println(isArithmeticSequence(new int[]{2, 5, 8, 11, 14}));
    }
}
