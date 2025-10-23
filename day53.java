import java.util.*;

class day53 {
    public static int reversepolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.next();
        }

        int res = reversepolishNotation(tokens);
        System.out.println(res);

        sc.close();
    }
}

















/* 



import java.util.*;

public class Day53 {

    public static int reversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("Error: Expression is empty.");
        }

        for (String token : tokens) {
            // Check if the token is an operator
            if (isOperator(token)) {

                // Not enough operands before an operator
                if (stack.size() < 2) {
                    throw new IllegalArgumentException(
                        "Error: Not enough operands before operator '" + token + "'."
                    );
                }

                int a = stack.pop();
                int b = stack.pop();

                // Perform the operation safely
                switch (token) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        if (a == 0) {
                            throw new ArithmeticException("Error: Division by zero.");
                        }
                        stack.push(b / a);
                        break;
                }

            } else {
                // Try parsing it as an integer
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                        "Error: Invalid token '" + token + "' — not a number or operator."
                    );
                }
            }
        }

        // After processing all tokens, only one value should remain
        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                "Error: Invalid RPN expression — leftover operands or missing operators."
            );
        }

        return stack.pop();
    }

    // Utility function to check if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tokens: ");

        // Handle non-integer input safely
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer count.");
            sc.close();
            return;
        }

        if (n <= 0) {
            System.out.println("Error: Token count must be greater than zero.");
            sc.close();
            return;
        }

        System.out.println("Enter tokens (numbers/operators) separated by spaces:");
        String[] tokens = new String[n];

        for (int i = 0; i < n; i++) {
            tokens[i] = sc.next();
        }

        try {
            int result = reversePolishNotation(tokens);
            System.out.println("✅ Result: " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        sc.close();
    }
}
 */