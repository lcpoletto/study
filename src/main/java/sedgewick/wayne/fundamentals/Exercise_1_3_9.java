package sedgewick.wayne.fundamentals;

import edu.princeton.cs.algs4.StdOut;
import sedgewick.wayne.adts.Stack;

/**
 * 1.3.9 Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For
 * example, given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Exercise_1_3_9 {

    public static String infixExpression(final String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        final String[] data = input.split(" ");
        final Stack<String> operations = new Stack<>();
        final Stack<String> values = new Stack<>();
        for (final String datum : data) {
            if (datum.equals("+") || datum.equals("-") || datum.equals("*") || datum.equals("/") || datum.equals("sqrt")) {
                operations.push(datum);
            } else if (datum.equals(")")) {
                String operation = operations.pop();
                String value = values.pop();
                if (operation.equals("sqrt")) {
                    value = String.format("( %s %s )", operation, value);
                } else {
                    value = String.format("( %s %s %s )", values.pop(), operation, value);
                }

                values.push(value);
            } else {
                values.push(datum);
            }
        }

        return values.pop();
    }
}
