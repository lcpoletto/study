package skiena.sorting;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by poletto on 5/29/2017.
 */
public class TestBinarySearch {

    @Test
    public void testQuickSort() {
        final int size = 500;
        final Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = StdRandom.uniform(size * 3);
        }

        final Integer element = array[StdRandom.uniform(size)];
        Assert.assertTrue(BinarySearch.search(array, element) > -1);
    }
}
