package sedgewick.wayne.sorting;

/**
 * Created by poletto on 5/28/2017.
 */
public class MergeBottomUp<T extends Comparable<T>> extends Sorter<T> {

    @Override
    public void sort(final T[] a) {
        final T[] aux = (T[]) new Comparable[a.length];

        // we start with sub arrays of capacity 1, and we double the capacity every time
        for (int size = 1; size < a.length; size *= 2) {
            for (int start = 0; start + size < a.length; start += size + size) {
                final int mid = start + size - 1;
                final int end = Math.min(start + size + size - 1, a.length - 1);
                merge(a, aux, start, mid, end);
                show(a);
            }
        }
    }

    /**
     * Will merge two sorted sides of array a.
     * <p>
     * s       m           e
     * 0 1 2 3 4 | 5 6 7 8 9
     * 2 4 5 6 7 | 1 2 3 4 8
     *
     * @param a     array to be merged
     * @param start starting position of sorted elements
     * @param mid   middle position of sorted elements
     * @param end   end position of sorted elements
     */
    private void merge(final T[] a, final T[] aux, int start, int mid, int end) {
        // copy all elements from start to end onto aux array
        System.arraycopy(a, start, aux, start, end - start + 1);

        int left = start;
        int right = mid + 1;

        for (int i = start; i <= end; i++) {
            if (left > mid) {
                // this means we're done with all elements on the left side, so we just copy from right
                a[i] = aux[right++];
            } else if (right > end) {
                // this means we're done with all elements on the right side, so just copy from left
                a[i] = aux[left++];
            } else if (less(aux[right], aux[left])) {
                // move left to right
                a[i] = aux[right++];
            } else {
                a[i] = aux[left++];
            }
        }
    }
}
