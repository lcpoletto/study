package com.carrercup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.careercup.com/question?id=5715358729109504
 */
public class BinaryMatrix {

    private static final int[][] MATRIX = {
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    // this was the first version, it worked, but it's way more complicated than the verticalRun
    private static void run() {
        int highest = -1;
        List<Integer> result = new LinkedList<>();
        int rowLength = MATRIX[0].length;
        for (int y = 0; y < MATRIX.length; y++) {
            for (int x = 0; x < rowLength; x++) {
                if (MATRIX[y][x] == 1) {
                    if (rowLength - x > highest) {
                        highest = rowLength - x;
                        if (!result.isEmpty()) {
                            // java implementation will iterate on all links and mark them to null due to GC
                            // considerations
                            result.clear();
                        }
                        result.add(y);
                    } else if (rowLength - x == highest) {
                        result.add(y);
                    }
                    continue;
                }
            }
        }

        for (Integer row: result) {
            System.out.println("Row: " + (row + 1) + " size: " + highest);
        }
    }

    private static void verticalRun() {
        int columns = MATRIX[0].length;
        boolean longestFound = false;
        for (int col = 0; col < columns && !longestFound; col++) {
            for (int row = 0; row < MATRIX.length; row++) {
                // I'm iterating on the columns top to bottom, so the first '1' I find will mean I'm on the
                // longest sequence, we just need to continue to the bottom to make sure if there are any other
                // row with the same amount of 1s
                if (MATRIX[row][col] == 1) {
                    longestFound = true;
                    System.out.println("[" + (row + 1) + "," + (columns - col) + "]");
                }
            }
        }
    }

    public static void main(final String[] args) {
        run();
        verticalRun();
    }
}


