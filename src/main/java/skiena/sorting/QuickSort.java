package skiena.sorting;

/**
 * Created by poletto on 5/29/2017.
 */
public class QuickSort {

    private QuickSort() {
        // avoids instantiation
    }

    public static void sort(final Comparable[] a, int start, int end) {
        if (start < end) {
            final int p = partition(a, start, end);
            sort(a, start, p - 1);
            sort(a, p + 1, end);
        }
    }

    private static int partition(final Comparable[] a, final int start, final int end) {
        int pivot = end;
        int firstBigger = start;

        for (int i = start; i < end; i++) {
            if (a[i].compareTo(a[pivot]) < 0) {
                swap(a, i, firstBigger++);
            }
        }
        swap(a, pivot, firstBigger);
        return firstBigger;
    }

    private static void swap(final Comparable[] a, final int i, final int j) {
        final Comparable aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

}
