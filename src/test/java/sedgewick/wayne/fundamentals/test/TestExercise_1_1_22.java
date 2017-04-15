package sedgewick.wayne.fundamentals.test;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_22;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_1_22}.
 */
public class TestExercise_1_1_22 {

    private static final int ARRAY_SIZE = 50000;
    private static final int[] ARRAY = new int[ARRAY_SIZE];

    @BeforeClass
    public static void beforeClass() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            ARRAY[i] = i;
        }
    }

    @Test
    public void testFound() {
        final int random = StdRandom.uniform(0, ARRAY_SIZE);
        System.out.println("Searching for " + random);
        final int result = Exercise_1_1_22.rank(random, ARRAY);
        System.out.println("Found in position " + random);
        Assert.assertEquals("Result bigger than zero", true, result >= 0);
        Assert.assertEquals(random, result);
    }
}
