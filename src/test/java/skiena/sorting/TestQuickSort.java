package skiena.sorting;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by poletto on 5/29/2017.
 */
public class TestQuickSort {

    @Test
    public void testQuickSort() {
        final int size = 10;
        final Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = StdRandom.uniform(size * 3);
        }

        QuickSort.sort(array, 0, array.length - 1);

        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }
}
