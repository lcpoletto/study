package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_1_19;

/**
 * Created by poletto on 4/14/2017.
 */
public class TestExercise_1_1_19 {

    @Test
    public void testBaseCases() {
        long result = Exercise_1_1_19.fibonnaci(0);
        Assert.assertEquals(0, result);
        result = Exercise_1_1_19.fibonnaci(1);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testRegularCases() {
        final long result = Exercise_1_1_19.fibonnaci(45);
        Assert.assertEquals(1134903170, result);
    }

    @Test
    public void testAssertPerformance() {
        for (int i = 30; i < 46; i++) {
            final long normalStart = System.nanoTime();
            Exercise_1_1_19.F(i);
            final long normalFinish = System.nanoTime();
            final long normalTime = normalFinish - normalStart;

            final long arrayStart = System.nanoTime();
            Exercise_1_1_19.fibonnaci(i);
            final long arrayFinish = System.nanoTime();
            final long arrayTime = arrayFinish - arrayStart;
            System.out.printf("[%d] Normal time: %s ns, Array time: %s ns\n", i, normalTime, arrayTime);

            Assert.assertEquals("Array faster than normal", true, arrayTime < normalTime);
        }
    }
}
