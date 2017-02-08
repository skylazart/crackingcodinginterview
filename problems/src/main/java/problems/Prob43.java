package problems;

/**
 * Created by fsantos on 1/2/17.
 */

/*
Prob43:
We have a bag containing numbers 1, 2, 3, …, 100. Each number appears exactly once, so there are 100 numbers.
Now one number is randomly picked out of the bag. Find the missing number.
Now how would you do this if TWO numbers are missing?
 */
public class Prob43 {
    public static void remove(int[] arr, int N) {
        arr[N - 1] = 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[101];

        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        remove(arr, 3);
        remove(arr, 20);
        int totalSum = (100 * 101) / 2;

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        int missing = totalSum - sum;

        for (int i = 0; i < missing; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
