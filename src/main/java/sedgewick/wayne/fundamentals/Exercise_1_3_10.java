package sedgewick.wayne.fundamentals;

import sedgewick.wayne.adts.Stack;

/**
 * 1.3.10 Write a filter InfixToPostfix that converts an arithmetic expression from infix
 * to postfix.
 */
public class Exercise_1_3_10 {

    public static String infixToPostfix(final String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        final String[] data = input.split(" ");
        final Stack<String> operations = new Stack<>();
        final Stack<String> values = new Stack<>();

        for (final String s : data) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                operations.push(s);
            } else if (s.equals(")")) {
                String operation = operations.pop();
                String value = values.pop();
                if (operation.equals("sqrt")) {
                    value = String.format("( %s %s )", value, operation);
                } else {
                    value = String.format("( %s %s %s )", values.pop(), value, operation);
                }

                values.push(value);
            } else {
                if (!s.equals("(")) {
                    values.push(s);
                }
            }
        }
        return values.pop();
    }
}
