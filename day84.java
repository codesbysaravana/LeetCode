//DECODE STRINGS 394 leetcode
// its about (context switch + state saving)
import java.util.*;

class day84 {
    public static String DecodeStrings(String s) {
        Stack<StringBuilder> StringStack = new Stack<>();
        Stack<Integer> NumStack = new Stack<>();

        int num = 0;
        StringBuilder curr = new StringBuilder(); //current state 

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if(ch == '[') {
                NumStack.push(num);          //saving states
                StringStack.push(curr); 

                curr = new StringBuilder();  //reseting
                num = 0;
            }

            else if(ch == ']') { // pop from 2 stacks
                int repeat = NumStack.pop();
                StringBuilder prev = StringStack.pop();

                for(int i=0; i<repeat; i++) {
                    prev.append(curr);
                }

                curr = prev;
            }

            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}







/* 
Dsa NOTES
    Use two stacks: one for counts, one for previous strings
    [ → push count & current string, reset both     ------------------------------->   at [ store and reset
    ] → pop count & string, append current string count times
    curr always represents the active level
    Nested brackets handled naturally by stack
     */






class Factorial {
    public static int fact(int n) {
        if(n == 1) return 1;
        return n * fact(n-1);
    }
}

class Factorial {
    public static int fact(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }

        return dp[n];
    }
}



