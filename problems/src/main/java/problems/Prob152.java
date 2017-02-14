package problems;

/**
 * Created by fsantos on 2/9/17.
 */
public class Prob152 {
/*
Input : head = 3-->6-->7-->8-->9-->10-->11 , x=17
Output: (6, 11), (7, 10), (8, 9)
 */
    public static void main(String[] args) {
        int[] arr = new int[] {3, 6, 7, 8, 9, 10, 11};
        int wanted = 17;

        int mask = wanted - arr[0];

        for (int i = 1; i < arr.length; i++) {
            System.out.println("arr[i] " + arr[i]);
            System.out.println("mask " + mask);

            if ((arr[i] & mask) < mask) {
                System.out.println(arr[i]);
                continue;
            }

            mask |= wanted - arr[i];
        }
    }
}
