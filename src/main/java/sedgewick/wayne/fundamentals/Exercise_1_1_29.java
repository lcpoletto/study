package sedgewick.wayne.fundamentals;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * 1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a key and
 * a sorted array of int values (some of which may be equal) as arguments and returns the
 * number of elements that are smaller than the key and a similar method count() that
 * returns the number of elements equal to the key. Note : If i and j are the values returned
 * by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
 * the array that are equal to key.
 */
public class Exercise_1_1_29 {

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int smallerThanKey(final int[] array, final int key) {
        final int keyIndex = indexOf(array, key);
        if (keyIndex > 0) {
            int result = keyIndex;
            while (result > 0 && array[result] == key) {
                result--;
            }
            return result;
        }
        return -1;
    }

    public static int equalToKey(final int[] array, final int key) {
        final int smaller = smallerThanKey(array, key);
        if (smaller > 0) {
            int result = smaller;
            while (result < array.length && array[result] <= key) {
                result++;
            }
            // the first element after the smaller ones should be the first one
            // equal to the key
            return result - (smaller + 1);
        }
        return -1;
    }
}
