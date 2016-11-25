package problems;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob7 {
    public static void rotate90Degrees(int[][] matrix) {
        for (int l = 0; l <= matrix.length / 2; l++) {
            for (int c = l + 1; c < matrix[l].length; c++) {
                exchange(matrix, l, c);
            }
        }

        printMatrix(matrix);

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length / 2; c++) {
                exchange(matrix, l, c, l, matrix[l].length - (c + 1));
            }
        }
    }

    private static void exchange(int[][] matrix, int sourceL, int sourceC,
                                 int destinationL, int destinationC) {
        int t = matrix[destinationL][destinationC];
        matrix[destinationL][destinationC] = matrix[sourceL][sourceC];
        matrix[sourceL][sourceC] = t;
    }

    private static void exchange(int[][] matrix, int l, int c) {
        int t = matrix[l][c];
        matrix[l][c] = matrix[c][l];
        matrix[c][l] = t;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        printMatrix(matrix);
        rotate90Degrees(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (c > 0) System.out.print(" ");
                System.out.print(matrix[l][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
