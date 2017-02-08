package problems;

/**
 * Created by fsantos on 1/27/17.
 */
public class Prob111 {
    public static boolean find(int[][] matrix, int needed) {
        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while (left <= right) {
            int mid = midPoint(left, right);
            LC lc = new LC(mid, matrix[0].length);
            if (needed == matrix[lc.line][lc.column]) return true;
            if (needed > matrix[lc.line][lc.column]) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    private static int midPoint(int left, int right) {
        return left + (right - left) / 2;
    }

    private static class LC {
        private int line;
        private int column;

        public LC(int idx, int width) {
            this.line = idx / width;
            this.column = idx % width;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(find(matrix, 12));
    }
}
