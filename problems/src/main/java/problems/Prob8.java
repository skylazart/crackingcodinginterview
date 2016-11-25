package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fsantos on 11/25/16.
 */
public class Prob8 {
    public static void zeroNbyN(int[][] matrix) {
        Set<Integer> visitedColumn = new HashSet<>();
        Set<Integer> visitedLine = new HashSet<>();

        for (int l = 0; l < matrix.length; l++) {
            for (int c = 0; c < matrix[l].length; c++) {

                if (matrix[l][c] == 0) {
                    // Check visited nodes
                    if (visitedColumn.contains(c) || visitedLine.contains(l))
                        continue;

                    // Not visited
                    visitedColumn.add(c);
                    visitedLine.add(l);
                    fillLineColumn(matrix, l, c);
                }
            }
        }
    }

    private static void fillLineColumn(int[][] matrix, int l, int c) {
        // Filling the line
        for (int column = 0; column < matrix[l].length; column++) {
            matrix[l][column] = 0;
        }

        // Filling the column
        for (int line = 0; line < matrix.length; line++) {
            matrix[line][c] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
