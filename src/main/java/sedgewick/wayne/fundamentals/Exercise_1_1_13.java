package sedgewick.wayne.fundamentals;

import java.util.Arrays;

/**
 * 1.1.13 Write a code fragment to print the transposition (rows and columns changed)
 * of a two-dimensional array with M rows and N columns.
 */
public class Exercise_1_1_13 {

    public static int[][] transposition(final int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            // nothing to do
            return null;
        }

        // the new number of rows will be the longest current column
        // the number of columns will be the current number of rows
        int rows = matrix.length;
        int columns = 0;
        for (int row = 0; row < rows; row++) {
            if (matrix[row].length > columns) {
                columns = matrix[row].length;
            }
        }

        int[][] result = new int[columns][rows];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                result[column][row] = matrix[row][column];
            }
        }
        return result;
    }

}
