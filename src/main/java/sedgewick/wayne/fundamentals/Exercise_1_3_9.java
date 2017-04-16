package sedgewick.wayne.fundamentals;

/**
 * 1.3.9 Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For
 * example, given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
 */
public class Exercise_1_3_9 {

    public static String infixExpression(final String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        final String[] data = input.split(" ");
        for (final String datum : data) {
            
        }

        return null;
    }
}
