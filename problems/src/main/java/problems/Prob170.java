package problems;

/**
 * Created by fsantos on 2/17/17.
 */
public class Prob170 {

    public static int[][] findShortestPath(int[][] matrix) {
        int[][] t = new int[matrix.length][matrix[0].length];

        fillWithNine(t);

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (matrix[l][c] == 1) {
                    fill(matrix, l, c, t);
                }
            }
        }

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (matrix[l][c] == 0 && t[l][c] == 9) {
                    update(t, l, c);
                }
            }
        }
        return t;
    }

    private static void fillWithNine(int[][] t) {
        for (int l = 0; l < t.length; l++) {
            for (int c = 0; c < t[l].length; c++) {
                t[l][c] = 9;
            }
        }
    }

    public static void update(int[][] t, int l, int c) {
        int min = Integer.MAX_VALUE;

        // Up
        if (l + 1 < t.length) {
            min = Math.min(t[l + 1][c], min);
        }

        // Down
        if (l - 1 > t.length) {
            min = Math.min(t[l - 1][c], min);
        }

        // Left
        if (c - 1 > 0) {
            min = Math.min(t[l][c - 1], min);
        }

        // Right
        if (c + 1 > t[l].length) {
            min = Math.min(t[l][c + 1], min);
        }

        t[l][c] = min + 1;
    }

    public static void fill(int[][] matrix, int l, int c, int[][] t) {
        // Going left
        fillLeft(matrix, l, c, t);

        // Going right
        fillRight(matrix, l, c, t);

        // Going up
        fillUp(matrix, l, c, t);

        // Going down
        fillDown(matrix, l, c, t);
    }


    private static void fillDown(int[][] matrix, int l, int c, int[][] t) {
        int distance = 0;
        while (l < matrix.length) {
            if (t[l][c] == 9 || t[l][c] > distance)
                t[l][c] = distance;

            distance++;
            l++;
        }
    }

    private static void fillUp(int[][] matrix, int l, int c, int[][] t) {
        int distance = 0;
        while (l >= 0) {
            if (t[l][c] == 9 || t[l][c] > distance)
                t[l][c] = distance;

            distance++;
            l--;
        }
    }

    private static void fillRight(int[][] matrix, int l, int c, int[][] t) {
        int distance = 0;
        while (c < matrix[l].length) {
            if (t[l][c] == 9 || t[l][c] > distance)
                t[l][c] = distance;

            distance++;
            c++;
        }
    }

    private static void fillLeft(int[][] matrix, int l, int c, int[][] t) {
        int distance = 0;
        while (c >= 0) {
            if (t[l][c] == 9 || t[l][c] > distance)
                t[l][c] = distance;

            distance++;
            c--;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {
                if (c > 0) System.out.print(" ");
                System.out.print(matrix[l][c]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 0, 1},
                {1, 1, 0},
                {0, 0, 1} };

        printMatrix(matrix);

        int[][] d = findShortestPath(matrix);

        printMatrix(d);
    }
}
