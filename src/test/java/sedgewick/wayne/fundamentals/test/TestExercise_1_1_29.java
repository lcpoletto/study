package sedgewick.wayne.fundamentals.test;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_29;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_1_29}.
 */
public class TestExercise_1_1_29 {

    private static final int REPEAT = 50;
    private static final int ARRAY_SIZE = 50000;
    private static final int[] ARRAY = new int[ARRAY_SIZE];

    @BeforeClass
    public static void beforeClass() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            ARRAY[i] = i / REPEAT;
        }
    }

    @Test
    public void testSmaller() {
        // don't want to start on 0 because we will need to change assertion rules below
        final int random = StdRandom.uniform(10, ARRAY_SIZE / REPEAT);
        System.out.println("Searching for " + random);
        final int index = Exercise_1_1_29.indexOf(ARRAY, random);
        System.out.println("Found at index " + index);
        Assert.assertNotEquals(-1, index);
        final int smaller = Exercise_1_1_29.smallerThanKey(ARRAY, random);
        System.out.println(smaller + " elements smaller in the array.");
        Assert.assertEquals("Number of smaller between " + REPEAT + " range", true, index - REPEAT <= smaller);
    }

    @Test
    public void testCount() {
        final int random = StdRandom.uniform(10, ARRAY_SIZE / REPEAT);
        System.out.println("Searching for " + random);
        final int index = Exercise_1_1_29.indexOf(ARRAY, random);
        System.out.println("Found at index " + index);
        Assert.assertNotEquals(-1, index);
        final int smaller = Exercise_1_1_29.smallerThanKey(ARRAY, random);
        System.out.println(smaller + " smaller elements in the array.");
        final int equal = Exercise_1_1_29.equalToKey(ARRAY, random);
        System.out.println(equal + " equal elements in the array.");
        Assert.assertEquals(REPEAT, equal);
    }
}
