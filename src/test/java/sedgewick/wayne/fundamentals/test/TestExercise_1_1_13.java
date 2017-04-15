package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_13;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_1_13}.
 */
public class TestExercise_1_1_13 {

    private static final int[][] MATRIX = {
            {1, 2, 3, 4},
            {5, 6},
            {7, 8, 9}
    };

    @Test
    public void testEmptyOrNull() {
        int[][] result = Exercise_1_1_13.transposition(null);
        Assert.assertNull(result);
        result = Exercise_1_1_13.transposition(new int[][] {});
        Assert.assertNull(result);
        result = Exercise_1_1_13.transposition(new int[][] {{}});
        Assert.assertNull(result);
    }

    @Test
    public void testTransposed() {
        final int[][] result = Exercise_1_1_13.transposition(MATRIX);
        Assert.assertEquals(1, result[0][0]);
        Assert.assertEquals(2, result[1][0]);
        Assert.assertEquals(3, result[2][0]);
        Assert.assertEquals(4, result[3][0]);

        Assert.assertEquals(5, result[0][1]);
        Assert.assertEquals(6, result[1][1]);

        Assert.assertEquals(7, result[0][2]);
        Assert.assertEquals(8, result[1][2]);
        Assert.assertEquals(9, result[2][2]);
    }
}
