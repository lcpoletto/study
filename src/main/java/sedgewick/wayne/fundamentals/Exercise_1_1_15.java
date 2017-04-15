package sedgewick.wayne.fundamentals;

/**
 * 1.1.15 Write a static method histogram() that takes an array a[] of int values and
 * an integer M as arguments and returns an array of length M whose ith entry is the number
 * of times the integer i appeared in the argument array. If the values in a[] are all
 * between 0 and M–1, the sum of the values in the returned array should be equal to
 * a.length.
 */
public class Exercise_1_1_15 {

    public static int[] histogram(int[] array, int m) {
        if (array == null || array.length == 0 || m < 1) {
            return null;
        }
        // if M is not highest number on array plus one we're going to have an
        // ArrayIndexOutOfBoundsException
        int[] result = new int[m];
        for (int i = 0; i < array.length; i++) {
            // if the arguments are wrong this will throw an ArrayIndexOutOfBoundsException
            result[array[i]]++;
        }
        return result;
    }

}
