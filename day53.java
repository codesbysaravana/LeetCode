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
