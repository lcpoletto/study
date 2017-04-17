package sedgewick.wayne.fundamentals.test;

import org.junit.Assert;
import org.junit.Test;
import sedgewick.wayne.fundamentals.Exercise_1_3_10;

/**
 * Test fixture for {@link sedgewick.wayne.fundamentals.Exercise_1_3_10}.
 */
public class TestExercise_1_3_10 {

    /**
     * Test examples from here: http://www.cs.man.ac.uk/~pjj/cs2121/fix.html
     */
    @Test
    public void testInternetExamples() {
        String input = "( ( 1 * 2 ) + ( 3 / 4 ) )";
        String result = Exercise_1_3_10.infixToPostfix(input);
        Assert.assertEquals("( ( 1 2 * ) ( 3 4 / ) + )", result);

        input = "( ( 1 * ( 2 + 3 ) ) / 4 )";
        result = Exercise_1_3_10.infixToPostfix(input);
        Assert.assertEquals("( ( 1 ( 2 3 + ) * ) 4 / )", result);

        input = "( 1 * ( 2 + ( 3 / 4 ) ) )";
        result = Exercise_1_3_10.infixToPostfix(input);
        Assert.assertEquals("( 1 ( 2 ( 3 4 / ) + ) * )", result);
    }

    @Test
    public void testSquareRoot() {
        final String input = "( ( 1 * 2 ) + ( sqrt ( 3 / 4 ) ) )";
        final String result = Exercise_1_3_10.infixToPostfix(input);
        Assert.assertEquals("( ( 1 2 * ) ( ( 3 4 / ) sqrt ) + )", result);
    }
}
