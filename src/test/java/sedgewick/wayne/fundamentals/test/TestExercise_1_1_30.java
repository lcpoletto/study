package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_30;

/**
 * Test fixture for {@link Exercise_1_1_30}
 */
public class TestExercise_1_1_30 {

    @Test
    public void testBaseCases() {
        boolean[][] matrix = Exercise_1_1_30.primeMatrix(0);
        Assert.assertNull(matrix);
        matrix = Exercise_1_1_30.primeMatrix(2);
        Assert.assertNotNull(matrix);
        Assert.assertEquals(2, matrix.length);
    }

    @Test
    public void testRelativePrimes() {
        final boolean[][] matrix = Exercise_1_1_30.primeMatrix(10);
        Assert.assertEquals(false, matrix[2][4]);
        Assert.assertEquals(false, matrix[4][2]);
        Assert.assertEquals(false, matrix[8][4]);
        Assert.assertEquals(false, matrix[9][3]);
        Assert.assertEquals(false, matrix[3][6]);
        Assert.assertEquals(true, matrix[9][8]);
        Assert.assertEquals(true, matrix[1][1]);
        Assert.assertEquals(true, matrix[9][9]);
        Assert.assertEquals(true, matrix[7][6]);
    }
}
