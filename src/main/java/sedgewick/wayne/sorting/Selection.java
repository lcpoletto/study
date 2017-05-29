package sedgewick.wayne.sorting;

/**
 * Created by poletto on 5/26/2017.
 */
public class Selection<T extends Comparable<T>> extends Sorter<T> {

    @Override
    public void sort(final T[] a) {
        for (int i = 0; i < a.length; i++) {
            // assume the minimal element
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    // find the smallest one
                    min = j;
                }
            }
            // swap the actual smallest element into current position
            swap(a, i, min);
        }
    }
}
