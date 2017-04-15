package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_15;

/**
 * Created by poletto on 4/14/2017.
 */
public class TestExercise_1_1_15 {

    @Test
    public void testBaseCases() {
        int[] result = Exercise_1_1_15.histogram(null, 10);
        Assert.assertNull(result);
        result = Exercise_1_1_15.histogram(new int[] {}, 10);
        Assert.assertNull(result);
        result = Exercise_1_1_15.histogram(new int[] {1, 2, 3, 4}, 0);
        Assert.assertNull(result);
    }

    @Test
    public void testRegularCases() {
        final int[] input = {0, 1, 1, 2, 3, 4, 4, 4, 5};
        final int[] result = Exercise_1_1_15.histogram(input, 6);
        Assert.assertEquals(result.length, 6);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(1, result[2]);
        Assert.assertEquals(1, result[3]);
        Assert.assertEquals(3, result[4]);
        Assert.assertEquals(1, result[5]);
    }

    @Test
    public void testArraySum() {
        final int[] input = {0, 1, 2, 3, 4, 5};
        final int m = 6;
        final int[] result = Exercise_1_1_15.histogram(input, m);
        Assert.assertEquals(result.length, m);

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += result[i];
        }

        Assert.assertEquals(input.length, sum);
    }

}
