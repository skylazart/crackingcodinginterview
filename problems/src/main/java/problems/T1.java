package problems;

/**
 * Created by fsantos on 1/6/17.
 */
public class T1 {
    public static IntSumPair findSum(int[] arr, int N) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == N)
                    return new IntSumPair(i, j);
            }
        }
        return new IntSumPair(-1, -1);
    }

    private static class IntSumPair {
        private int a;
        private int b;

        public IntSumPair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return "[a: " + a + " b:" + b + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println(findSum(new int[]{1, 2, 3, 4, -1}, 0));
    }
}
