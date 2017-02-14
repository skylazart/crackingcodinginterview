package problems;

/**
 * Created by fsantos on 2/9/17.
 */
public class Prob148 {
    public static int maxCels(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int componentes = 3;

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (matrix[l][c] == 1)
                    max = Math.max(max, dfs(matrix, l, c, componentes, 0));
            }
        }

        return max;
    }

    private static int dfs(int[][] matrix, int l, int c, int component, int count) {
        if (l < 0 || l >= matrix.length)
            return count;

        if (c < 0 || c > matrix[l].length)
            return count;

        if (matrix[l][c] == 1) {
            count++;
            matrix[l][c] = component;
            count = Math.max(count, dfs(matrix, l + 1, c, component, count));
            count = Math.max(count, dfs(matrix, l, c + 1, component, count));
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
        };

        System.out.println(maxCels(matrix));
    }
}
