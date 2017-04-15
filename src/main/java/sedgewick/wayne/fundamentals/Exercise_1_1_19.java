package sedgewick.wayne.fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * What is the largest value of N for which this program takes less 1 hour to compute the
 * value of F(N)? Develop a better implementation of F(N) that saves computed values in
 * an array.
 */
public class Exercise_1_1_19 {

    private static long[] computed;

    public static long fibonnaci(final int number) {
        if (computed == null) {
            computed = new long[number];
        }

        // here we need to increase the array size, but copying existing results
        // should be faster than recalculating them
        if (computed.length < number) {
            expandComputed(number);
        }

        if (number == 0) return 0;
        if (number == 1) return 1;

        // we have to offset the array by 1 as the first index is 0
        if (computed[number - 1] <= 0) {
            computed[number - 1] = fibonnaci(number - 1) + fibonnaci(number - 2);
        }
        return computed[number - 1];
    }

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    private static void expandComputed(final int length) {
        long[] newComputed = new long[length];
        for (int i = 0; i < computed.length; i++) {
            newComputed[i] = computed[i];
        }
        computed = newComputed;
    }
}
