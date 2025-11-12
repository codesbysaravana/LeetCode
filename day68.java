import java.util.*;

class day68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int res = Solution.reverse(n);

        System.out.println(res);

        sc.close();
    }
}

class Solution {
    public static int reverse(int n) {
        int x = 0;

        while(n != 0) {
            int a = n % 10;
            x = x * 10 + a;
            n = n/10;
        }
        
        return x;
    }
}