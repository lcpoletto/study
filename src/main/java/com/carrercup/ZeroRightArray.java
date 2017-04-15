package com.carrercup;

import java.util.Arrays;

/**
 * https://www.careercup.com/question?id=5737674640982016
 */
public class ZeroRightArray {

    private static final int[] ARRAY = {1, 2, 0, 5, 3, 0, 4, 0, 2, 0, 0, 3, 1};

    private static void run() {
        int zeroes = 0;
        int swapped = 0;
        for (int i = 0; i < ARRAY.length; i++) {
            if (ARRAY[i] == 0) {
                zeroes++;
                // as we're moving the zeroes to right, we can start the iteration at the latest zero position
                for (int j = ARRAY.length - 1 - swapped; j >= i; j--) {
                    if (ARRAY[j] != 0) {
                        int nonZero = ARRAY[j];
                        ARRAY[j] = 0;
                        ARRAY[i] = nonZero;
                        swapped++;
                        // we did the swap, no need to continue this for
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(ARRAY));
        System.out.println("Zeroes: " + (zeroes-swapped));
    }

    public static void main(String[] args) {
        run();
    }
}
