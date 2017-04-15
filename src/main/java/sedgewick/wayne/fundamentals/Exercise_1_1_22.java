package sedgewick.wayne.fundamentals;

/**
 * 1.1.22 Write a version of BinarySearch that uses the recursive rank() given on page
 * 25 and traces the method calls. Each time the recursive method is called, print the argument
 * values lo and hi, indented by the depth of the recursion. Hint: Add an argument
 * to the recursive method that keeps track of the depth.
 */
public class Exercise_1_1_22 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        String output = "";
        for (int i = 0; i < depth; i++) {
            output += "\t";
        }
        output += "[" + depth + "] lo: " + lo + " hi: " + hi;
        System.out.println(output);
        // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
        else return mid;
    }
}
