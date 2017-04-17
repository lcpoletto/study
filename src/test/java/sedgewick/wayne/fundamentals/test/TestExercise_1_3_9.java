package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_3_9;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_3_9}.
 */
public class TestExercise_1_3_9 {

    @Test
    public void testBookExample() {
        final String result = Exercise_1_3_9.infixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        Assert.assertEquals("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )", result);
    }

    @Test
    public void testSqrt() {
        final String result = Exercise_1_3_9.infixExpression("sqrt 1 + 2 ) )");
        Assert.assertEquals("( sqrt ( 1 + 2 ) )", result);
    }
}
