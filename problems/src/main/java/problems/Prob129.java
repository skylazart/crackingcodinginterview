package problems;

/**
 * Created by fsantos on 2/3/17.
 */
public class Prob129 {
    public static boolean findSeats(int[] row, int k) {
        int[] copy = new int[row.length + 2];
        copy[0] = 0;
        copy[copy.length - 1] = 0;
        for (int i = 0; i < row.length; i++) {
            copy[i + 1] = row[i];
        }

        int maxConsecutiveZeros = 0;
        int count = 0;

        int prev = -1;

        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == 0)
                count++;
            else {
                maxConsecutiveZeros = Math.max(maxConsecutiveZeros, count);
                count = 0;
            }
        }

        maxConsecutiveZeros = Math.max(maxConsecutiveZeros, count);

        if (k + 2 <= maxConsecutiveZeros) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSeats(new int[]{0, 1, 0}, 2));
    }
}
