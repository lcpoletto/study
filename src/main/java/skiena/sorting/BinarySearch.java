package skiena.sorting;

import java.util.Arrays;

/**
 * Created by poletto on 5/29/2017.
 */
public class BinarySearch {

    private BinarySearch() {
        // avoids instantiation
    }

    public static int search(final Comparable[] a, Comparable e) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("An array with data must be received.");
        }
        Arrays.sort(a);
        return search(a, e, 0, a.length - 1);
    }

    private static int search(final Comparable[] a, Comparable e, int low, int high) {
        if (low > high) {
            // element not found
            return -1;
        }
        final int middle = (low + high) / 2;
        final int cmp = a[middle].compareTo(e);
        if (cmp == 0) {
            // found the element
            return middle;
        }
        if (cmp > 0) {
            // middle element is bigger, search lower portion
            return search(a, e, low, middle - 1);
        }
        // middle element is smaller, search higher portion
        return search(a, e, middle + 1, high);
    }
}
