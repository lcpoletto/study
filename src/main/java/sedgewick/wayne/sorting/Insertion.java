package sedgewick.wayne.sorting;

/**
 * Created by poletto on 5/26/2017.
 */
public class Insertion<T extends Comparable<T>> extends Sorter<T> {

    @Override
    public void sort(final T[] a) {
        for (int i = 0; i < a.length; i++) {
            // we start at the same position as i and go backwards while j element is smaller then j - 1
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }
}
