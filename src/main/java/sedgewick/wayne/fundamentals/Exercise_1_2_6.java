package sedgewick.wayne.fundamentals;

/**
 * 1.2.6 A string s is a circular rotation of a string t if it matches when the characters
 * are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
 * TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
 * sequences. Write a program that checks whether two given strings s and t are circular
 * shifts of one another. Hint : The solution is a one-liner with indexOf(), length(), and
 * string concatenation.
 */
public class Exercise_1_2_6 {

    public static boolean areCircular(final String one, final String two) {
        if (one == null || one.isEmpty() || two == null || two.isEmpty()) {
            return false;
        }
        if (one.length() != two.length()) {
            return false;
        }
        final String comparator = one + one;
        return comparator.indexOf(two) > -1;
    }
}
