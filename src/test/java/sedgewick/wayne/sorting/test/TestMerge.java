package sedgewick.wayne.sorting.test;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.sorting.Merge;
import sedgewick.wayne.sorting.MergeBottomUp;

/**
 * Created by poletto on 5/28/2017.
 */
public class TestMerge {

    @Test
    public void testTopDownIntegers() {
        final int size = 15;
        final Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = StdRandom.uniform(size * 3);
        }

        final Merge<Integer> merge = new Merge<>();
        merge.sort(array);

        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testBottomUpIntegers() {
        final int size = 15;
        final Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = StdRandom.uniform(size * 3);
        }

        final MergeBottomUp<Integer> merge = new MergeBottomUp<>();
        merge.sort(array);

        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(array[i] <= array[i + 1]);
        }
    }
}
