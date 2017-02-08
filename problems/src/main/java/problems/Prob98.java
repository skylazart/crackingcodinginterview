package problems;

/**
 * Created by fsantos on 1/23/17.
 */
public class Prob98 {
    public static boolean compare(int N, int A, int B, int C, int D) {
        int sum1 = A + B + C + D;
        double div1 = (double) sum1 / 4;
        double div2 = (double) (sum1 + N) / 5;

        return Math.abs(div1 - div2) == 0;
    }

    public static void main(String[] args) {
        System.out.println(compare(1, 1, 1, 1, 1));
        System.out.println(compare(2, 1, 1, 1, 1));
    }

}
