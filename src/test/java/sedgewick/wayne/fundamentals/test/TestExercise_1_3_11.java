package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_3_11;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_3_11}
 */
public class TestExercise_1_3_11 {

    /**
     * Test examples from here: http://www.cs.man.ac.uk/~pjj/cs2121/fix.html
     */
    @Test
    public void testInternetExamples() {
        String input = "( ( 1 2 * ) ( 3 4 / ) + )";
        double result = Exercise_1_3_11.evaluatePostfix(input);
        Assert.assertEquals(2.75, result, 0);

        input = "( ( 1 ( 2 3 + ) * ) 4 / )";
        result = Exercise_1_3_11.evaluatePostfix(input);
        Assert.assertEquals(1.25, result, 0);

        input = "( 1 ( 2 ( 3 4 / ) + ) * )";
        result = Exercise_1_3_11.evaluatePostfix(input);
        Assert.assertEquals(2.75, result, 0);
    }
}
