package sedgewick.wayne.fundamentals;

/**
 * 1.1.30 Array exercise. Write a code fragment that creates an N-by-N boolean array
 * a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors),
 * and false otherwise.
 */
public class Exercise_1_1_30 {

    public static boolean[][] primeMatrix(final int size) {
        if (size <= 0) {
            return null;
        }
        final boolean[][] result = new boolean[size][size];
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                result[i][j] = gcd(i, j) <= 1 || i == j;
            }
        }
        return result;
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
